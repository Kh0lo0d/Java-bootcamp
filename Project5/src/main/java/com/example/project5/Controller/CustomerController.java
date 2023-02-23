package com.example.project5.Controller;

import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAllLCustomer() {
        List<Customer> customers = customerService.getAllLCustomer();
        return ResponseEntity.status(200).body(customers);

    }

    @PostMapping("/add")
    public ResponseEntity addNewCustomer(@Valid @RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
        return ResponseEntity.status(200).body("customer added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStore(@PathVariable Integer id, @Valid @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body("customer updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("customer deleted");
    }

}