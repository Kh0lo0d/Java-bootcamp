package com.example.final_project_training.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Training_Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="Name should be not empty")
    @Column(columnDefinition = "varchar(50) unique not null ")
    private String name;
     @NotEmpty(message="category should be not empty")
     @Pattern(regexp="^(Online|In_Home|Out_Home|Plan_Training)$",
             message="Wrong category ,category should be Online or In_Home or Out_Home or Plan_Training only")
    private String category;

    @NotEmpty(message="time_Period should be not empty")
     @Pattern(regexp="^(Weekly|Monthly|Daily)$",
             message="Wrong time_Period ,time_Period should be Weekly or Monthly or Daily  only")
    private String time_Period;
    @NotNull(message="price should be not empty")
    @Positive(message="price must be Integer and grater than 0")
    private double price;

    @ManyToOne
    @JoinColumn(name ="coach_id",referencedColumnName ="id" )
    @JsonIgnore
    private Coach coach;


@ManyToOne
@JoinColumn(name ="order_id",referencedColumnName ="id" )
@JsonIgnore
    private Order_table orderTable;



}
