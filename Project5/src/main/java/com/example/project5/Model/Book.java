package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jdk.security.jarsigner.JarSigner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotEmpty(message="Name should be not empty")
    @Column(columnDefinition = "varchar(10) unique not null ")
    private String name;
    @NotNull(message="bookCount should be not empty")
    @Positive(message="bookCount must be number")
    private Integer bookCount;
    @NotEmpty(message="Name should be not empty")
    @Column(columnDefinition = "varchar(10)  not null ")
    private String genre;



@ManyToOne
    @JoinColumn(name ="store_id",referencedColumnName ="id" )
    @JsonIgnore
    private Store store;

}
