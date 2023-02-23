package com.example.final_project_training.Repositary;

import com.example.final_project_training.Model.Training_Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface Training_Repositary extends JpaRepository<Training_Services,Integer> {
    //Training_Services findTraining_ServicesById(Integer id);
    Training_Services findTraining_ServicesById(Integer id);
}
