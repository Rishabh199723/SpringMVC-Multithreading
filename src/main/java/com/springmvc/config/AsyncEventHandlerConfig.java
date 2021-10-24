package com.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class AsyncEventHandlerConfig {

   /* @Bean
    ApplicationEventMulticaster eventMulticaster() {
        SimpleApplicationEventMulticaster caster = new SimpleApplicationEventMulticaster();
        caster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return  caster;
    }*/
}
