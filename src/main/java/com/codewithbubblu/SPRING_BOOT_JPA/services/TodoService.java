package com.codewithbubblu.SPRING_BOOT_JPA.services;

import com.codewithbubblu.SPRING_BOOT_JPA.model.Todos;
import com.codewithbubblu.SPRING_BOOT_JPA.model.AppUser;
import com.codewithbubblu.SPRING_BOOT_JPA.repository.TodosRepository;
import com.codewithbubblu.SPRING_BOOT_JPA.repository.UserRepository;
import com.codewithbubblu.SPRING_BOOT_JPA.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService  {
    @Autowired
     TodosRepository todosRepository;

    @Autowired
     UserRepository userRepository;

    public List<Todos> getAllTodos(int userId){
        return todosRepository.findAll()
                .stream()
                .filter((todos -> todos.getAppUser().getId()==userId))
                .collect(Collectors.toList());
    }

//  //  public Optional<Todos> getTodosById(int id){
//        return todosRepository.findById(id);
//    }

    public List<Todos> createTodos(TodoRequest todo){
        Todos originalTodo = new Todos();
        originalTodo.setTodo(todo.getTodo());
        AppUser appUser = userRepository.findById(todo.getUserId()).get();
        originalTodo.setAppUser(appUser);
        todosRepository.save(originalTodo);
        return getAllTodos(todo.getUserId());
    }

    public List<Todos> updateTodos(TodoRequest todo){
        Todos originalTodo = new Todos();
        originalTodo.setId(todo.getId());
        originalTodo.setTodo(todo.getTodo());
        AppUser appUser = userRepository.findById(todo.getUserId()).get();
        originalTodo.setAppUser(appUser);
        todosRepository.save(originalTodo);
        return getAllTodos(todo.getUserId());
    }

    public List<Todos> deleteTodosById(Integer id){
        int userId=todosRepository.findById(id).get().getAppUser().getId();
        todosRepository.deleteById(id);
        return getAllTodos(userId);
    }

}
