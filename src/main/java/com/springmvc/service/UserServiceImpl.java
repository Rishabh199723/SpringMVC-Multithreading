package com.springmvc.service;

import com.springmvc.AppConstants.AppConstant;
import com.springmvc.entity.User;
import com.springmvc.event.CustomTriggerEvent;
import com.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApplicationEventPublisher publisher;

    @Override
    public String saveUser(User user) {
        Optional<String> userSaved = Optional.ofNullable(userRepository.saveUser(user));
        if(userSaved.isPresent()) {
            System.out.println("Thread -- "+Thread.currentThread().getName());
            publisher.publishEvent(new CustomTriggerEvent(this,"1", AppConstant.USER_SAVED));
            return userSaved.get();
        } else {
            return "Not saved";
        }
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.fetchAllUsers();
    }
}
