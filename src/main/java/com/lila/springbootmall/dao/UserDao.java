package com.lila.springbootmall.dao;

import com.lila.springbootmall.dto.UserRegisterRequest;
import com.lila.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
