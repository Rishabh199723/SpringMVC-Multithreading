package com.springmvc.listener;


import com.springmvc.entity.Todo;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

public class CustomListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("CONTECT CREATED");

        List<Todo> todos = new ArrayList<Todo>();
        ServletContext context = servletContextEvent.getServletContext();
        context.setAttribute("todos", todos);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
