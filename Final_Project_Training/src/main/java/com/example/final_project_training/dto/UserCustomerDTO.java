package com.example.final_project_training.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCustomerDTO {

    private Integer user_id;

    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @Column(columnDefinition = "varchar(10) not null")
    private String phone_number;
    @Column(columnDefinition = "int not null")
    private Integer age;
    @Column(columnDefinition = "int not null")
    private Integer length;
    @Column(columnDefinition = "int not null")
    private Integer weight;
    @Column(columnDefinition = "varchar(30) not null")
    private String health_problem;
    @Column(columnDefinition = "varchar(30) not null")
    private String city;
    @Column(columnDefinition = "varchar(100) not null")
    private String address;

    @NotEmpty(message="email should be not empty")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    @Column(columnDefinition = "varchar(25) unique not null")
    private String email;
    @NotEmpty(message="gender should be not empty")
    @Pattern(regexp="^(Female|Male)$",
            message="Wrong gender ,gender should be Female or Male only")
    private String gender;
}
