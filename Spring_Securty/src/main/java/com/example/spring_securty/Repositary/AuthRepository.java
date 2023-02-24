package com.example.spring_securty.Repositary;

import com.example.spring_securty.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<MyUser,Integer> {

    MyUser findMyUserByUsername(String username);

}
