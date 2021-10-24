package com.springmvc.service;

import com.springmvc.entity.User;

import java.util.List;

public interface UserService {
    String saveUser(User user);

    List<User> fetchAllUsers();
}
