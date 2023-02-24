package com.example.final_project_training.Service;

import com.example.final_project_training.Exception.ApiException;
import com.example.final_project_training.Model.Customer;
import com.example.final_project_training.Model.Order_table;
import com.example.final_project_training.Repositary.Customer_Repository;
import com.example.final_project_training.Repositary.Order_Repositary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Customer_Service {
    private final Customer_Repository customerRepository;
    private final Order_Repositary orderRepositary;

    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer newCustomer) {
        Customer oldCustomer = customerRepository.findCustomerById(id);
        if (oldCustomer == null) {
            throw new ApiException("Customer not found");
        }
        oldCustomer.setName(newCustomer.getName());
        oldCustomer.setPhone_number(newCustomer.getPhone_number());
        oldCustomer.setAge(newCustomer.getAge());
        oldCustomer.setLength(newCustomer.getLength());
        oldCustomer.setWeight(newCustomer.getWeight());
        oldCustomer.setHealth_problem(newCustomer.getHealth_problem());
        oldCustomer.setCity(newCustomer.getCity());
        oldCustomer.setAddress(newCustomer.getAddress());
        oldCustomer.setEmail(newCustomer.getEmail());
        oldCustomer.setGender(newCustomer.getGender());
        customerRepository.save(oldCustomer);
    }

    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new ApiException("Customer not found");
        }
        customerRepository.delete(customer);
    }

    public void OrdersAssignedtoCutomer(Integer customer_id, Integer order_id) {
        Customer customer = customerRepository.findCustomerById(customer_id);
        Order_table orderTable = orderRepositary.findOrder_tableById(order_id);
        if (customer == null || orderTable == null) {
            throw new ApiException("customer Or order not Found");
        } else {
            orderTable.setCustomer(customer);
            orderRepositary.save(orderTable);

        }

    }
    //Get all customers whose orders are accepted
    public List<Customer> getListCustomer(String status){
        Order_table orderTable = orderRepositary.findOrder_tableByStatus(status);

        if(orderTable != null && orderTable.getStatus()=="ACCEPT")
        {

            List<Customer> customers = customerRepository.findAll();

            // orderRepositary.save(orderTable);
            return customers;

        }

        throw new ApiException("Incorrect Input");
    }

}