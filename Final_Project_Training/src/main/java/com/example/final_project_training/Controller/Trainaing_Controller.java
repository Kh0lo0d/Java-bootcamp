package com.example.final_project_training.Controller;

import com.example.final_project_training.Model.Coach;
import com.example.final_project_training.Model.Training_Services;
import com.example.final_project_training.Service.OrderServices;
import com.example.final_project_training.Service.TraingSrevice_Services;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/training")
public class Trainaing_Controller {
    private final TraingSrevice_Services traingSreviceServices;
    private final OrderServices orderServices;

    @GetMapping("/getAll-TrainingServices")
    public ResponseEntity getAllTrainingServices() {
        return ResponseEntity.status(200).body(traingSreviceServices.getAllTrainingServices());
    }

    @PostMapping("/add-TrainingServices")
    public ResponseEntity addNewTraining(@Valid @RequestBody Training_Services training_services) {
        traingSreviceServices.addNewTraining(training_services);
        return ResponseEntity.status(200).body("Training Service  has been added successfully ");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTraining(@PathVariable Integer id, @Valid @RequestBody Training_Services training_services) {
        traingSreviceServices.updateTraining(id, training_services);

        return ResponseEntity.status(200).body("Training Service  has been updated successfully");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTrainingServices(@PathVariable Integer id) {

        traingSreviceServices.deleteTrainingServices(id);

        return ResponseEntity.status(200).body("Training Service  has been deleted successfully");
    }

    @PutMapping("/{coach_id}/Training/{training_id}")
    public ResponseEntity assignCoachToTrainingServices(@PathVariable Integer coach_id, @PathVariable Integer training_id){
        traingSreviceServices.assignCoachToTrainingServices(coach_id, training_id);
        return ResponseEntity.status(200).body("COACH ASSIGN TRAINING SERVICES");
    }




}