package com.example.final_project_training.Controller;

import com.example.final_project_training.Model.Order_table;
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



   @PutMapping("/{training_id}/order-train/{order_id}")
    public ResponseEntity assignTrainingServicesToOrder(@PathVariable Integer training_id,@PathVariable Integer order_id){
        orderServices.assignTrainingServicesToOrder(training_id,order_id);
        return ResponseEntity.status(200).body("TRAINING SERVICES ASSIGN TO ORDER ");
    }

    //1.Get Order Details by Order Id
    @GetMapping("/details/{coach_id}")
    public ResponseEntity OrderDetails(@PathVariable Integer coach_id){
        List<Order_table> order = orderServices.OrderDetails(coach_id);
        return ResponseEntity.status(200).body(order);
    }
    //3. Change order status from "Pending" to "Accept" and  Change order status from "Accept" to "Completed"
    //3. Change order status from "Pending" to "REJECT"
    @GetMapping("/status/{id}")
    public ResponseEntity OrderStatus(@PathVariable Integer id){
        Order_table orders = orderServices.OrderStatus(id);
        return ResponseEntity.status(200).body(orders);

    }


    @GetMapping("/Get_Discount/{customer_id}")
    public ResponseEntity discount_Price(@PathVariable Integer customer_id)
    {
        Double price_discount= orderServices.discount_Price(customer_id);
        return ResponseEntity.status(200).body("The total price after discount  :"+price_discount);

    }






}
