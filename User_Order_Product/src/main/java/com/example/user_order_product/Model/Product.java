package com.example.user_order_product.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotEmpty(message="Name should be not empty")
    @Column(columnDefinition = "varchar(10) unique not null ")
    private String name;
    @NotNull(message="price should be not empty")
    @Positive(message="price must be Integer and grater than 0")
    private double price;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    private Set<Orders> orders;
}
