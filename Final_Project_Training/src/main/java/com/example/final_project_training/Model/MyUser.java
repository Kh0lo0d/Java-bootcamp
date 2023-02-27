package com.example.final_project_training.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(30) not null unique")
    private String username;
    //@Column(columnDefinition = "varchar(6) not null unique")
    private String password;

    @Column(columnDefinition = "varchar(30) not null check (role= 'Customer' or role= 'Coach' or role='Admin')")
    private String role;

    //@OneToOne(cascade = CascadeType.ALL,mappedBy = "myUser")
    //@PrimaryKeyJoinColumn
    //private Customer customer;

   /* @OneToOne(cascade = CascadeType.ALL,mappedBy = "myUser")
    @PrimaryKeyJoinColumn
    private Coach coach;*/

    @OneToOne(mappedBy = "myUser",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    Customer customer;

   @OneToOne(mappedBy = "myUser",cascade = CascadeType.ALL)
   @PrimaryKeyJoinColumn
     Coach coach;

   //@OneToOne
 // @MapsId
  //@JsonIgnore
   //private Customer customer;
}
