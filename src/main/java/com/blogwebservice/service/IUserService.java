package com.blogwebservice.service;

import com.blogwebservice.model.User;

public interface IUserService extends IService<User> {
    User checkLogin(String username, String password);
}
