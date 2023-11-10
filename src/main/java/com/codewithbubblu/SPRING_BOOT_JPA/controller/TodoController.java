package com.codewithbubblu.SPRING_BOOT_JPA.controller;

import com.codewithbubblu.SPRING_BOOT_JPA.model.Todos;
import com.codewithbubblu.SPRING_BOOT_JPA.request.TodoRequest;
import com.codewithbubblu.SPRING_BOOT_JPA.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    TodoService todoService;

//    @GetMapping("/{id}")
//    public Optional<Todos> getById(@PathVariable int id) {
//        return todoService.getTodosById(id);
//    }

    @GetMapping("all/{userid}")
    public List<Todos> get(@PathVariable int userid) {
        return todoService.getAllTodos(userid);
    }

    @PostMapping
    public List<Todos> add(@RequestBody TodoRequest todo) {
        return todoService.createTodos(todo);
    }

    @PutMapping
    public List<Todos> update(@RequestBody TodoRequest todo) {
        return todoService.updateTodos(todo);
    }

    @DeleteMapping("/delete/{id}")
    public List<Todos> delete(@PathVariable int id) {
        return todoService.deleteTodosById(id);
    }
}
