package com.example.project5.Repositary;

import com.example.project5.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositary extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer id);
}
