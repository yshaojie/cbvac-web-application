package com.cbvac.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class CbvacWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbvacWebApplication.class, args);
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.masterdatasource")
	public DataSourceProperties masterDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix="spring.masterdatasource")
	public DataSource masterDatasource() {
		return masterDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	@ConfigurationProperties(prefix="spring.slavedatasource")
	public DataSource slaveDatasource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public JdbcTemplate masterJdbcTemplate(DataSource masterDatasource){
		System.out.println(masterDatasource);
		System.out.println(masterDatasource());
		return new JdbcTemplate(masterDatasource());
	}

	@Bean
	public JdbcTemplate slaveJdbcTemplate(DataSource masterDatasource){
		return new JdbcTemplate(masterDatasource);
	}
}
