package com.example.user_order_product.Advice;

import com.example.user_order_product.Exception.ApiExceptin;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice

public class ControllerAdvice {

    @ExceptionHandler(value = ApiExceptin.class)
    public ResponseEntity ApiException(ApiExceptin e)
    {
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        String message =e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);

    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ApiExceptin> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new ApiExceptin(msg));
    }
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ApiExceptin>EntityNotFoundException(EntityNotFoundException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new ApiExceptin(msg));
    }
    @ExceptionHandler(value=IllegalArgumentException.class)
    public ResponseEntity<ApiExceptin>IllegalArgumentException(IllegalArgumentException e)
    {
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new ApiExceptin(msg));
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ApiExceptin> NullPointerException(NullPointerException e)
    {
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new ApiExceptin(msg));
    }
    @ExceptionHandler(value = CommandAcceptanceException.class)
    public ResponseEntity<ApiExceptin> CommandAcceptanceException(CommandAcceptanceException e)
    {
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new ApiExceptin(msg));
    }
}
