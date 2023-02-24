package com.example.spring_securty.Exception;

public class ApiException extends RuntimeException{
    public ApiException(String message)
    {
        super(message);
    }
}
