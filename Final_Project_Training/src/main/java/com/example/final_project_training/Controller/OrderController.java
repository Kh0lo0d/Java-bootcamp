package com.example.final_project_training.Controller;

import com.example.final_project_training.Model.Order_table;
import com.example.final_project_training.Model.Training_Services;
import com.example.final_project_training.Service.OrderServices;
import com.example.final_project_training.Service.TraingSrevice_Services;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderServices orderServices;
    private final TraingSrevice_Services traingSreviceServices;
    @GetMapping("/getAll-Order")
    public ResponseEntity getAllOrders() {
        return ResponseEntity.status(200).body(orderServices.getAllOrders());
    }

    @PostMapping("/add-Order")
    public ResponseEntity addNewOrder(@Valid @RequestBody Order_table orderTable) {
        orderServices.addNewOrder(orderTable);
        return ResponseEntity.status(200).body("Order  has been added successfully ");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @Valid @RequestBody Order_table orderTable) {
      orderServices.updateOrder(id,orderTable);
        return ResponseEntity.status(200).body("Order has been updated successfully");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id) {
         orderServices.deleteOrder(id);
        return ResponseEntity.status(200).body("Order  has been deleted successfully");
    }

    @PutMapping("/{coach_id}/coachOrder/{order_id}")
    public ResponseEntity assignCoachToOrderTable(@PathVariable Integer coach_id, @PathVariable Integer order_id){
        orderServices.assignCoachToOrderTable(coach_id, order_id);
        return ResponseEntity.status(200).body("COACH ASSIGN ORDER");
    }

   /* @PutMapping("/{training_id}/order-train/{order_id}")
    public ResponseEntity assignTrainingServicesToOrder(@PathVariable Integer training_id,@PathVariable Integer order_id){
        orderServices.assignTrainingServicesToOrder(training_id,order_id);
        return ResponseEntity.status(200).body("TRAINING SERVICES ASSIGN TO ORDER ");
    }*/






}
