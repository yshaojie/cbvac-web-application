package com.luo.web.luowebapplication.dao;

import com.luo.web.luowebapplication.bean.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author shaojieyue
 * Created at 2019-07-18 14:56
 */
public interface UserRepository  extends CrudRepository<User, Long> {

//    @Query(value = "select * from user where id=?1",nativeQuery=true)
//    public User findById(long id);
}
