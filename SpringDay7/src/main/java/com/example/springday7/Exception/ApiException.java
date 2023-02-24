package com.example.springday7.Exception;

public class ApiException extends RuntimeException{
    public ApiException(String message)
    {
        super(message);
    }
}
