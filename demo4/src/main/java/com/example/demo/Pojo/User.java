package com.example.demo.Pojo;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@AllArgsConstructor
public class User {

    @NotEmpty(message="User name should be not Empty ")
    @Size(min=4,max=8,message="User name should be more than 3 and less than 9")
    private String userName;
    @NotEmpty(message = "Password should be not Empty ")

    private String password;
}


