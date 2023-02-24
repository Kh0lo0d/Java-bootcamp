package com.example.final_project_training.Model;

import jakarta.persistence.*;
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
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @Column(columnDefinition = "varchar(30) not null")
    private String phone_number;
    @Column(columnDefinition = "varchar(30) not null")
    private String license;
    @Column(columnDefinition = "int not null")
    private Integer year_of_experience;
    @Column(columnDefinition = "int not null")
    private Integer price;

    @NotEmpty(message="gender should be not empty")
    @Pattern(regexp="^(Female|Male)$",
            message="Wrong gender ,gender should be Female or Male only")
    private String gender;

    @Column(columnDefinition = "varchar(30) not null")
    private String city;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "coach")
    private List<Training_Services> training_services;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "coach")
    private List<Order_table> orderTables;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coach")
    private List<Reviews> reviews;


}
