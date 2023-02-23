package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDetalis {
    @Id
    private Integer id;
    private Integer age;
    private String phone_number;
    private String gender;

}
