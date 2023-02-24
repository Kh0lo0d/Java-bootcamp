package com.example.final_project_training.Service;

import com.example.final_project_training.Exception.ApiException;
import com.example.final_project_training.Model.Coach;
import com.example.final_project_training.Model.Customer;
import com.example.final_project_training.Model.Order_table;
import com.example.final_project_training.Model.Training_Services;
import com.example.final_project_training.Repositary.Coach_Repository;
import com.example.final_project_training.Repositary.Order_Repositary;
import com.example.final_project_training.Repositary.Training_Repositary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class TraingSrevice_Services {

    private final Training_Repositary training_repositary;
    private  final Order_Repositary orderRepositary;
    private final Coach_Repository coachRepository;

    public List getAllTrainingServices() {
        return training_repositary.findAll();
    }

    public void addNewTraining(Training_Services training_services) {
        training_repositary.save(training_services);



    }

    public void updateTraining(Integer id,Training_Services training_services){
        Training_Services old_Training=training_repositary.getById(id);
        if(old_Training==null){
            throw new ApiException("Training service is not found");
            }
        old_Training.setName(training_services.getName());
        old_Training.setCategory(training_services.getCategory());
        old_Training.setTime_Period(training_services.getTime_Period());
        old_Training.setPrice(training_services.getPrice());
     training_repositary.save(old_Training);
    }

    public void deleteTrainingServices(Integer id) {
        Training_Services old_Training=training_repositary.getById(id);

        if (old_Training == null) {
            throw new ApiException("Training service is not found");
        } else
            training_repositary.deleteById(id);

    }

    public void assignCoachToTrainingServices(Integer coach_id,Integer training_id)
    {
        Coach coach=coachRepository.findCoachById(coach_id);
        Training_Services training_services=training_repositary.findTraining_ServicesById(training_id);

        if (coach == null || training_services == null) {
            throw new ApiException("coach Or training services not Found");
        } else {
            training_services.setCoach(coach);
            training_repositary.save(training_services);

        }




    }





}





