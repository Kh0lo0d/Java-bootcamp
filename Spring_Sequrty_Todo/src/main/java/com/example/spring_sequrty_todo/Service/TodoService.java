package com.example.spring_sequrty_todo.Service;

import com.example.spring_sequrty_todo.Exception.ApiException;
import com.example.spring_sequrty_todo.Model.Todo;
import com.example.spring_sequrty_todo.Repositary.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;


    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    public void addTodo(Integer id,Todo todo) {
        todo.setUserId(id);
        todoRepository.save(todo);
    }

    public void removeTodo(Integer userId, Integer todoId) {
        Todo todo=todoRepository.findById(todoId).get();

        if(todo.getUserId()!=userId){
            throw new ApiException("id not found");
        }

        todoRepository.deleteById(todoId);
    }

    public void updateTodo(Integer id , Todo todo){

        Todo todo1 = todoRepository.findTodoById(id);
        if(todo1 == null) {
            throw new ApiException("id not found");
        }

        todo1.setMessage(todo.getMessage());
        todo1.setUserId(todo.getUserId());
        todoRepository.save(todo1);
    }



}
