package com.example.final_project_training.Repositary;

import com.example.final_project_training.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUser_Repository extends JpaRepository<MyUser,Integer> {
    MyUser findMyUserById(Integer id);
    MyUser findMyUserByUsername(String username);


}
