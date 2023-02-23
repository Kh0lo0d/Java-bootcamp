package com.example.demo.controller;

import com.example.demo.Api.ApiResponse;
import com.example.demo.Pojo.User;
import jakarta.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("api/v1")
public class UserController {

    ArrayList<User>users=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<User>getTodo()
    {
        return users;
    }

    @PostMapping("/add")
    public ApiResponse addUser(@Valid @RequestBody User user, Errors errors)
    {
       if(errors.hasErrors())
       {
           String message =errors.getFieldError().getDefaultMessage();
           return new ApiResponse(message);
       }

       users.add(user) ;
       return new ApiResponse("User added");


    }

    @PutMapping("/update/{index}")
    public ApiResponse udateTodo(@PathVariable int index, @RequestBody User todo) {
        users.set(index, todo);
        return new ApiResponse("User Updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTodo(@PathVariable int index)
    {
        users.remove(index);
        return new ApiResponse("object has been deleted");
    }



}
