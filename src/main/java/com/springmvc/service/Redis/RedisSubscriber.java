package com.springmvc.service.Redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;


public class RedisSubscriber implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("Message received "+ message.toString());
    }
}
