package com.example.demo.Repositry;

import com.example.demo.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositry extends JpaRepository<Customer,Integer> {

}
