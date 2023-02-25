package com.example.final_project_training.Service;

import com.example.final_project_training.Exception.ApiException;
import com.example.final_project_training.Model.*;
import com.example.final_project_training.Repositary.Coach_Repository;
import com.example.final_project_training.Repositary.Order_Repositary;
import com.example.final_project_training.Repositary.Reviews_Repository;
import com.example.final_project_training.Repositary.Training_Repositary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Coach_Service {
    private final Coach_Repository coachRepository;
    private final Training_Repositary training_repositary;
    private final Reviews_Repository reviewsRepository;
    private final Order_Repositary orderRepositary;

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
        oldCoach.setGender(newCoach.getGender());
        oldCoach.setCity(newCoach.getCity());
        coachRepository.save(oldCoach);
    }

    public void deleteCoach(Integer id){
        Coach Coach = coachRepository.findCoachById(id);
        if (Coach == null){
            throw new ApiException("Coach not found");
        }
        coachRepository.delete(Coach);
    }
    //Coach have different orders(1:M)
    public void OrdersAssignedtoCaoch(Integer coach_id, Integer order_id){
        Coach coach = coachRepository.findCoachById(coach_id);
        //Order_table order = (Order_table) orderRepositary.findOrder_tableById(order_id);
        Order_table order = orderRepositary.findOrder_tableById(order_id);
        if(coach == null || order == null){
            throw new ApiException("Coach or Order not found");
        }
        order.setCoach(coach);
        orderRepositary.save(order);

    }
    //Coach have different Reviews(1:M)
    public void ReviewsAssignedtoCaoch(Integer coach_id, Integer review_id){
        Coach coach = coachRepository.findCoachById(coach_id);
        Reviews review = reviewsRepository.findReviewsById(review_id);
        if(coach == null || review == null){
            throw new ApiException("Coach or Review not found");
        }

        review.setCoach(coach);
        reviewsRepository.save(review);
    }

}
