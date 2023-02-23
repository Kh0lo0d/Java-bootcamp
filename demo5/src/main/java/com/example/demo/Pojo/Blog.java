package com.example.demo.Pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Blog {
    @NotNull(message=" should be not Empty ")
    @Positive(message="The id should be over than 0")
    private int id;
    @NotEmpty(message="The title should be not Empty ")
    private String title;
    @NotEmpty(message="The body should be not Empty ")

    private String body;
}
