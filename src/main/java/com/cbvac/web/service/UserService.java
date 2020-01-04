package com.cbvac.web.service;

import com.cbvac.web.bean.User;
import com.cbvac.web.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shaojieyue
 * Created at 2019-07-18 14:54
 */

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    public User findById(long id) {
        System.out.println(userRepository.findById(id));

        return userRepository.findById(id).orElse(null);
    }
}
