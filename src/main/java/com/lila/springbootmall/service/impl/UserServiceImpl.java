package com.lila.springbootmall.service.impl;

import com.lila.springbootmall.dao.UserDao;
import com.lila.springbootmall.dto.UserRegisterRequest;
import com.lila.springbootmall.model.User;
import com.lila.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
