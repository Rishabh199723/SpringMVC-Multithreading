package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class redisPublisherImpl implements RedisPublisherService {

    @Autowired
    RedisTemplate<String ,Object> template;

    @Autowired
    ChannelTopic topic;



    @Override
    @Async
    public String publishMessage(String msg) {
        try {
            System.out.println("channel==="+topic.getTopic());
            System.out.println("msg===="+msg);
            template.convertAndSend(topic.getTopic(), msg);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return "Message Published";
    }
}
