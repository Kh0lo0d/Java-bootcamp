package com.example.spring_securty.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private  String message;

    private Integer userId;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    @JsonIgnore
    private  MyUser myUser;

    public Todo(Object o, String tod1, MyUser user) {
    }
}
