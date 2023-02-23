package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Location {

    @Id
    private  Integer id;
    @NotEmpty(message="area should be not empty")
    @Column(columnDefinition = "varchar(10)  not null ")
    private String area;
    @NotEmpty(message="area should be not empty")
    @Column(columnDefinition = "varchar(10)  not null ")
    private String street;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Store store;

}
