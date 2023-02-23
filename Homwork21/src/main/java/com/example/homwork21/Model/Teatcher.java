package com.example.homwork21.Model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teatcher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotEmpty(message="Name should be not empty")
    @Column(columnDefinition = "varchar(10) unique not null ")
    private String name;
    @NotNull(message="The Age should be not Empty ")
    @Positive(message="The Age should be over than 0")
    @Min(value=20,message="The Age should be over than 20 ")
    private Integer age;
    @NotEmpty(message="email should be not empty")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    @Column(columnDefinition = "varchar(25) unique not null")
    private String email;
    @NotNull(message="salary should be not empty")
    @Positive(message="salary must be Integer and grater than 0")
    private double salary;

}
