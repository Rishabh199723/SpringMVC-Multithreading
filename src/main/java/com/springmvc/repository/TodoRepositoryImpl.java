package com.springmvc.repository;

import com.springmvc.entity.Todo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveTodo(Todo todo) {
        Session session = sessionFactory.getCurrentSession();

        //session.save(todo);
    }
}
