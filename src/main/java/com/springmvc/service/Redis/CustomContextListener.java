package com.springmvc.service.Redis;

import com.springmvc.AppConstants.AppConstant;
import com.springmvc.event.CustomTriggerEvent;
import com.springmvc.service.RedisPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CustomContextListener implements ApplicationListener<CustomTriggerEvent> {

    @Autowired
    RedisPublisherService publisherService;

    @Override
    @Async
    public void onApplicationEvent(CustomTriggerEvent applicationEvent) {
        System.out.println("Thread -- "+Thread.currentThread().getName());
        String eName = applicationEvent.geteName();
        System.out.println("In application event handler");
        if(eName.equals(AppConstant.USER_SAVED)){
            publisherService.publishMessage(AppConstant.USER_SAVED);
        }
    }
}
