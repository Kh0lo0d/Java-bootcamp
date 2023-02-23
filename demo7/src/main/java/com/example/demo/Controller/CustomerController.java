package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.CustomerDetalis;
import com.example.demo.Service.CustomerService;
import com.example.demo.Service.DetalisService;
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
    public ResponseEntity getAllCustomer()
    {
        List<Customer> customers=customerService.getAllCustomer();
        return ResponseEntity.status(200).body(customers);

    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Customer customer)
    {
        customerService.addCustomer((customer));

        return ResponseEntity.status(200).body("customer added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDetalies(@PathVariable Integer id, @Valid @RequestBody Customer customer)
    {
boolean isUbdate=customerService.updateCustomer(id,customer);


        if(isUbdate==true)
            return ResponseEntity.status(200).body("customer updated");

        else

            return ResponseEntity.status(400).body("Wrong id");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDetalies(@PathVariable Integer id){
        boolean isDeleted= customerService.deleteCustomer(id);
        if(isDeleted==true)
            return ResponseEntity.status(200).body("customer deleted");
        else
            return ResponseEntity.status(400).body("Wrong id");

    }






}
