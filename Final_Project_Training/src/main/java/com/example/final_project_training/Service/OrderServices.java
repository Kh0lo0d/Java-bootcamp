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
private final Customer_Repository customerRepository;
    public List<Order_table> getAllOrders() {
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


    public void assignTrainingServicesToOrder(Integer training_id,Integer order_id){

        Order_table orderTable=orderRepositary.findOrder_tableById(order_id);
        Training_Services trainingServices=training_repositary.findTraining_ServicesById(training_id);
        if(orderTable ==null || trainingServices==null){
            throw new ApiException("Training Services Or Order not found");}
        else{
            trainingServices.setOrderTable(orderTable);
            training_repositary.save(trainingServices);


        }
    }

    //1.Get Order Details by Coach Id
    public List<Order_table> OrderDetails(Integer coach_id){
        Order_table orterTable= orderRepositary.findOrder_tableById(coach_id);
        if(orterTable == null){
            throw new ApiException("Coach don't have any Orders");
        }


        return orderRepositary.findOrder_tableByCoachId(coach_id);
    }

    //A. Change order status from "Pending" to "Accept and by default 'IN PROGRESS'
    //PENDING|ACCEPT|REJECT|COMPLETE
    public Order_table AcceptStatus(Integer customer_id){
        Order_table orterTable = orderRepositary.findOrter_tableByCustomerId(customer_id);
        if(orterTable != null && orterTable.getStatus().equals("PENDING")){
            orterTable.setStatus("IN PROGRESS");
            orderRepositary.save(orterTable);
            return orterTable;
        }
        throw new ApiException("Order Status is not 'IN PROGRESS' ");}
    //B.Change order status from "Accept" to "Completed"
    public Order_table CompletedStatus(Integer customer_id){
        Order_table orterTable = orderRepositary.findOrter_tableByCustomerId(customer_id);
        if(orterTable != null && orterTable.getStatus().equals("ACCEPT")){
            orterTable.setStatus("COMPLETE");
            orderRepositary.save(orterTable);
            return orterTable;
        }
        throw new ApiException("Order Status is not 'ACCEPTED' ");}

    //D. Change order status from "Pending" to "REJECT"
    //PENDING|ACCEPT|REJECT|COMPLETE
    public Order_table RejectStatus(Integer customer_id){
        Order_table orterTable = orderRepositary.findOrter_tableByCustomerId(customer_id);
        if(orterTable != null && orterTable.getStatus().equals("PENDING")){
            orterTable.setStatus("REJECT");
            orderRepositary.save(orterTable);
            return orterTable;
        }
        throw new ApiException("Order Status is not 'IN PENDING' ");}


    //If the customer orders more than one  the customer gets a 20% discount
    public Double discount_Price(Integer customer_id) {
        Customer customer = customerRepository.findCustomerById(customer_id);
        List<Order_table> orderTable = customer.getOrder_tables();


        if (customer == null) {
            throw new ApiException("customer not found");
        }
        double price, total_price = 0;
        if (orderTable.size() > 1) {
            for (int i = 0; i < orderTable.size(); i++) {

                price = orderTable.get(i).getTotal_price();
                total_price = total_price + price;
            }

            }
            if(orderTable.size()==1)

                throw new ApiException("You can not get a discount");
Double p=total_price;
customer.setOrder_tables(orderTable);
customerRepository.save(customer);
       return p*0.2; }



}















