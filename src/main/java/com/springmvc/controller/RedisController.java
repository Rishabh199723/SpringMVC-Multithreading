package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.exceptions.UserNotFoundException;
import com.springmvc.service.RedisPublisherService;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RedisController {

    @Autowired
    UserService userService;
    @Autowired
    RedisPublisherService publisherService;

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user) {
//        throw new UserNotFoundException("Kuch na mila");
        return userService.saveUser(user);
    }

    @GetMapping("/appUsers")
    public ResponseEntity<List<User>> fetchAllUsers() {
        List<User> users = userService.fetchAllUsers();
        if(users.size()>0) {
            return ResponseEntity.status(HttpStatus.OK).body(users);
        } else{
            throw new UserNotFoundException("No users found");
        }
    }

    @GetMapping("/publish/{msg}")
    public ResponseEntity<String> publishMessage(@PathVariable("msg") String msg) {
        Optional<String> data = Optional.ofNullable(publisherService.publishMessage(msg));
        if(data.isPresent()) {
         return ResponseEntity.ok(data.get());
        } else {
            return ResponseEntity.internalServerError().body("Some Exception Occurred");
        }
    }

}
