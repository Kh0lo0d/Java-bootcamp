package com.example.project5.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotEmpty(message="Name should be not empty")
    @Column(columnDefinition = "varchar(10) unique not null ")
    private String name;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "store")
    @PrimaryKeyJoinColumn
    Location location;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "store")
    private Set<Book>books;

    @ManyToMany(mappedBy = "stores")
    private Set<Customer>customers;

}
