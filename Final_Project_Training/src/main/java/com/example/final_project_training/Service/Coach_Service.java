package com.example.final_project_training.Service;

import com.example.final_project_training.Exception.ApiException;
import com.example.final_project_training.Model.*;
import com.example.final_project_training.Repositary.Coach_Repository;
import com.example.final_project_training.Repositary.Training_Repositary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Coach_Service {
    private final Coach_Repository coachRepository;
    private final Training_Repositary training_repositary;

    public List<Coach> getCoach(){
        return coachRepository.findAll();
    }
    public void addCoach(Coach coach){
        coachRepository.save(coach);
    }

    public void updateCoach(Integer id, Coach newCoach){
        Coach oldCoach = coachRepository.findCoachById(id);
        if(oldCoach == null){
            throw new ApiException("Coach not found");
        }
        oldCoach.setName(newCoach.getName());
        oldCoach.setPhone_number(newCoach.getPhone_number());
        oldCoach.setLicense(newCoach.getLicense());
        oldCoach.setYear_of_experience(newCoach.getYear_of_experience());
        oldCoach.setPrice(newCoach.getPrice());
        oldCoach.setGender(newCoach.getGender());
        coachRepository.save(oldCoach);
    }

    public void deleteCoach(Integer id){
        Coach Coach = coachRepository.findCoachById(id);
        if (Coach == null){
            throw new ApiException("Coach not found");
        }
        coachRepository.delete(Coach);
    }




}
