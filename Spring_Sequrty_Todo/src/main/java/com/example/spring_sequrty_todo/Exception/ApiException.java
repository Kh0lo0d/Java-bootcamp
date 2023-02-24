package com.example.spring_sequrty_todo.Exception;

public class ApiException extends RuntimeException{
    public ApiException(String message)
    {
        super(message);
    }
}
