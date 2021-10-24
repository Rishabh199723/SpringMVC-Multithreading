package com.springmvc.repository;

import com.springmvc.entity.User;
import com.springmvc.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    RedisTemplate template;

     final String USER_KEY = "USER";

    @Override
    public String saveUser(User user) {
        try {
            template.opsForValue().set(user.getId().toString(), user);
            return "User saved";
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> fetchAllUsers() {
        return template.opsForHash().values(USER_KEY);
    }

}
