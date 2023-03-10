package com.example.spring_securty.Service;

import com.example.spring_securty.Exception.ApiException;
import com.example.spring_securty.Model.Todo;
import com.example.spring_securty.Repositary.TodoRepository;
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
