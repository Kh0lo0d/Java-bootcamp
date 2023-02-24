package com.example.spring_sequrty_todo.Repositary;

import com.example.spring_sequrty_todo.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Integer> {
    List<Todo> findAllByUserId(Integer userId);

    Todo findTodoById(Integer id);
}
