package com.springmvc.repository;

import com.springmvc.entity.User;

import java.util.List;

public interface UserRepository {
    String saveUser(User user);

    List<User> fetchAllUsers();
}
