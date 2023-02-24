package com.example.spring_securty.Repositary;

import com.example.spring_securty.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
    List<Todo> findAllByUserId(Integer userId);
    List<Todo> findAllByMyUser(Integer id);

    Todo findTodoById(Integer id);

}
