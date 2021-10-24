package com.springmvc.controller;

import com.springmvc.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class MultiThreadController {

    @Autowired
    TodoService todoService;
    @Autowired
    ThreadPoolTaskExecutor executor;

    @GetMapping(value = "/fetchList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> fetchList() throws ExecutionException, InterruptedException {
        CompletableFuture<List<String>> list1 =  todoService.fetchList();
        CompletableFuture<List<String>> list2 =  todoService.fetchList();
        CompletableFuture<List<String>> list3 =  todoService.fetchList();
//         CompletableFuture.allOf(list1,list2,list3);
//        list2.join();
        List<String> list = Stream.of(list1,list2,list3).map(CompletableFuture::join).flatMap(List::stream).collect(Collectors.toList());
        System.out.println("List1============="+list1.isDone());
        System.out.println("List2============="+list2.isDone());
        System.out.println("List3============="+list3.isDone());
        /*while(executor.getActiveCount()>0) {
            *//*System.out.println("Multithreading in progress");
            System.out.println("Done============="+list1.isDone());
            System.out.println("Done============="+list2.isDone());*//*
        }*/
//        List<String> finalList = list1.get();
        //finalList.addAll(list2.get());
        /*CompletableFuture<String> list1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("IN STR1");
            return "test";
        });
        CompletableFuture<String> list2 = list1.thenApply(s->{
            return s+"Hello";
        });
        System.out.println("list2==="+list2.get());

        System.out.println("finalList");*/
        return ResponseEntity.ok(list);
    }

    CompletableFuture<Integer> computeAnother(Integer i){
        return CompletableFuture.supplyAsync(() -> 10 + i);
    }
}
