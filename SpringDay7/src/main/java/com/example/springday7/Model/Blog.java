package com.example.springday7.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Blog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message="should be not empty")
   // @Column(columnDefinition = "Integer not null")
    private String title;

    @NotEmpty(message="should be not empty")
    @Column(columnDefinition = "varchar(300) not null")
    private String body;

}
