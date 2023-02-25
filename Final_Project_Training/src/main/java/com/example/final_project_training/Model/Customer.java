package com.example.final_project_training.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
    @Column(columnDefinition = "varchar(30) not null")
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



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Order_table> order_tables;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Training_Services> training_services;
}
