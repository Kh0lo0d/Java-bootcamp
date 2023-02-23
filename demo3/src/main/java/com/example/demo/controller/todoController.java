package com.example.demo.controller;

import com.example.demo.Api.ApiResponse;
import com.example.demo.Pojo.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1")
public class todoController {


    ArrayList<Todo>todos=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Todo>getTodo()
    {
        return todos;
    }


    @PostMapping("/add")
    public ApiResponse addTodo(@RequestBody Todo todo)
    {
        todos.add(todo);
        return new ApiResponse("Add");
    }

@PutMapping("/ubdate/{index}")
    public String udateTodo(@PathVariable int index,@RequestBody Todo todo)
{
    todos.set(index,todo);
    return "Todo ubdate";
}

@DeleteMapping("/delete/{index}")
public String deleteTodo(@PathVariable int index)
    {
        todos.remove(index);
        return"Todo delete";
    }
}

