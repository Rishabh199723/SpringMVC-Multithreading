package com.springmvc.aop;


import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Component
@Aspect
public class CustomAop {

    @Before("execution(* com.springmvc.service.UserServiceImpl.saveUser(..))")
    public void preSave() {
        System.out.println("before save");
    }
}
