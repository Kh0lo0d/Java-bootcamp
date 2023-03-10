package com.example.final_project_training.Repositary;

import com.example.final_project_training.Model.Customer;
import com.example.final_project_training.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository public interface Customer_Repository extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer id);
    List<Customer>findAllByMyUser(MyUser myUser);

}
