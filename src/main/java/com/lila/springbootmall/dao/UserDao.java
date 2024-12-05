package com.lila.springbootmall.dao;

import com.lila.springbootmall.dto.UserRegisterRequest;
import com.lila.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
