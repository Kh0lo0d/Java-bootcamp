package com.example.spring_securty.Advice;

import com.example.spring_securty.Exception.ApiException;
import jakarta.persistence.TransactionRequiredException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.id.IdentifierGenerationException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ApiException.class)

    public ResponseEntity ApiException(ApiException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    //TransactionRequiredException

    @ExceptionHandler(value = TransactionRequiredException.class)

    public ResponseEntity TransactionRequiredException(TransactionRequiredException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    //IdentifierGenerationException
    @ExceptionHandler(value = IdentifierGenerationException.class)

    public ResponseEntity IdentifierGenerationException(IdentifierGenerationException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
//IllegalStateException

    @ExceptionHandler(value = BeanCreationException.class)
    public ResponseEntity BeanCreationException(BeanCreationException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
//NonUniqueResultException

    @ExceptionHandler(value = NonUniqueResultException.class)
    public ResponseEntity NonUniqueResultException(NonUniqueResultException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    //UnsatisfiedDependencyException

    @ExceptionHandler(value = UnsatisfiedDependencyException.class)
    public ResponseEntity UnsatisfiedDependencyException(UnsatisfiedDependencyException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    // NullPointerException
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity NullPointerException(NullPointerException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ApiException>SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(new ApiException(message));
    }


    // Server Validation Exception
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiException> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiException(message));
    }

    // Method not allowed Exception
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiException> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(new ApiException(message));
    }
}
