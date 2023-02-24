package com.example.spring_sequrty_todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

    private String message;
    private Integer status;
}
