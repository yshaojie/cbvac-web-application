package com.cbvac.web.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @author shaojieyue
 * Created at 2019-07-18 14:55
 */

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
}
