package com.springmvc.controller;

import com.springmvc.entity.Todo;
import com.springmvc.service.TodoService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletContext;
import java.util.*;

@Controller
public class HomeController {
    @Autowired
    TodoService todoService;

    @Autowired
    ServletContext context;

    @Autowired
    SessionFactory sessionFactory;
    @RequestMapping("/home")
    public String home(Model m, @ModelAttribute("showNotification") String showNotification) {
        m.addAttribute("page", "viewTodo");
        List<Todo> list = (List<Todo>) context.getAttribute("todos");
        Collections.sort(list, new Comparator<Todo>() {
            @Override
            public int compare(Todo o1, Todo o2) {
                return o2.getDateCreated().compareTo(o1.getDateCreated());
            }
        });
        m.addAttribute("list", list);
        return "home";
    }

    @RequestMapping("/add")
    public String addTodo(Model m) {
        Todo t = new Todo();
        m.addAttribute("page", "addTodo");
        m.addAttribute("todo",t);
        return "home";
    }

    @PostMapping("/saveTodo")
    public ModelAndView saveTodo(@ModelAttribute("todo") Todo t) {
        t.setDateCreated(new Date());
        todoService.saveTodo(t);
        ModelAndView m = new ModelAndView("redirect:/home");
//        List<Todo> todos = (List<Todo>) context.getAttribute("todos");
//        todos.add(t);
        m.addObject("showNotification", true);
        System.out.println("Modalmap---"+m);
        return m;
    }
}
