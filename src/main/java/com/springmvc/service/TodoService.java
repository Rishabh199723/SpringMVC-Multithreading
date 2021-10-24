package com.springmvc.service;

import com.springmvc.entity.Todo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TodoService {

    public void saveTodo(Todo todo);

    public CompletableFuture<List<String>> fetchList();
}
