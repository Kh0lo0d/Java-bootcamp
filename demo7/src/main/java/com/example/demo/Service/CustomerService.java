package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Repositry.CustomerRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepositry customerRepositry;

    public List getAllCustomer() {

        return customerRepositry.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepositry.save(customer);


    }


    public boolean updateCustomer(Integer id,Customer customer){

        Customer oldCustomer=customerRepositry.getById(id);
        if(oldCustomer==null){
            return false;}

        oldCustomer.setName(customer.getName());
        customerRepositry.save(oldCustomer);
        return true;
    }

    public boolean deleteCustomer(Integer id) {
        Customer oldCustomer=customerRepositry.getById(id);
        if (oldCustomer == null) {
            return false;
        } else
            customerRepositry.deleteById(id);
        return true;

    }


}
