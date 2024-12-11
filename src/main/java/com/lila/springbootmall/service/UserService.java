package com.lila.springbootmall.service;

import com.lila.springbootmall.dto.UserLoginRequest;
import com.lila.springbootmall.dto.UserRegisterRequest;
import com.lila.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
