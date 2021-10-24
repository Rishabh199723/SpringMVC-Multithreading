package com.springmvc.service;

import com.springmvc.entity.Todo;
import com.springmvc.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoRepository repo;

    @Autowired
    ThreadPoolTaskExecutor executor;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveTodo(Todo todo) {
        repo.saveTodo(todo);
    }

    @Async
    @Override
    public CompletableFuture<List<String> > fetchList(){
        List<String> list = new ArrayList<>();
        try {
            Thread.sleep(10000);
            System.out.println("Current Thread name : "+Thread.currentThread().getName());
            System.out.println("No of active threads::"+executor.getActiveCount()+"========="+executor.getThreadPoolExecutor().getQueue().size()+"Time::"+new Date());
            for(int i=0;i<5;i++) {
                list.add(UUID.randomUUID().toString());
            }
        } catch (InterruptedException ex) {

        }
        return CompletableFuture.completedFuture(list);
    }

}
