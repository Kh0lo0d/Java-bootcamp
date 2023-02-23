package com.example.final_project_training.Service;

import com.example.final_project_training.Exception.ApiException;
import com.example.final_project_training.Model.Coach;
import com.example.final_project_training.Model.Customer;
import com.example.final_project_training.Model.Order_table;
import com.example.final_project_training.Model.Training_Services;
import com.example.final_project_training.Repositary.Coach_Repository;
import com.example.final_project_training.Repositary.Customer_Repository;
import com.example.final_project_training.Repositary.Order_Repositary;
import com.example.final_project_training.Repositary.Training_Repositary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class OrderServices {
    private final Order_Repositary orderRepositary;
private final Coach_Repository coachRepository;
private final Training_Repositary training_repositary;
    public List getAllOrders() {
        return orderRepositary.findAll();
    }

    public void addNewOrder(Order_table orderTable) {
        orderRepositary.save(orderTable);

    }

    public void updateOrder(Integer id,Order_table orderTable){
        Order_table old_Order=orderRepositary.getById(id);

        if(old_Order==null){
            throw new ApiException("Order Not Found !");}
        old_Order.setStart_Date(orderTable.getStart_Date());
        old_Order.setEnd_Date(orderTable.getEnd_Date());
        old_Order.setTime(orderTable.getTime());
        old_Order.setTotal_price(orderTable.getTotal_price());
        old_Order.setStatus(orderTable.getStatus());
        orderRepositary.save(old_Order);

    }
    public void deleteOrder(Integer id) {
        Order_table old_Order = orderRepositary.getById(id);

        if (old_Order == null) {
            throw new ApiException("Order Not Found !");
        } else
            orderRepositary.deleteById(id);


    }

        public void assignCoachToOrderTable(Integer coach_id,Integer order_id)
        {        Coach coach=coachRepository.findCoachById(coach_id);
            Order_table orderTable=orderRepositary.findOrder_tableById(order_id);

            if (coach == null || orderTable == null) {
                throw new ApiException("coach Or Order not Found");
            }
            else{
                orderTable.setCoach(coach);
                orderRepositary.save(orderTable);
            }

        }

    public void assignTrainingServicesToOrder(Integer training_id,Integer order_id){

        Training_Services training_services=training_repositary.findTraining_ServicesById(training_id);
        Order_table orderTable=orderRepositary.findOrder_tableById(order_id);
        if(training_services ==null || orderTable==null){
            throw new ApiException("Training Services Or Order not found");}
        else{
               training_services.getOrderTables().add(orderTable);
          orderTable.getTraining_services().add(training_services);
          training_repositary.save(training_services);
           orderRepositary.save(orderTable);

        }
    }
}















