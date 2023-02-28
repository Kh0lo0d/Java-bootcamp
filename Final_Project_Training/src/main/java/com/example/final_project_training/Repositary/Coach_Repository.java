package com.example.final_project_training.Repositary;

import com.example.final_project_training.Model.Coach;
import com.example.final_project_training.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Coach_Repository extends JpaRepository<Coach,Integer> {
    Coach findCoachById(Integer id);
    List<Coach>findCoachByCity(String city);

    List<Coach>findCoachByGender(String gender);

    List<Coach> findAllByMyUser(MyUser myUser);




}
