package com.example.project5.Service;

import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Location;
import com.example.project5.Repositary.CustomerRepositary;
import com.example.project5.Repositary.StroreRepositary;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepositary customerRepositary;
    private final StroreRepositary stroreRepositary ;
    public List getAllLCustomer(){
        return customerRepositary.findAll();
    }

    public void addNewCustomer(Customer customer){
        customerRepositary.save(customer);
    }
    public void updateCustomer(Integer id,Customer customer)
    {
        Customer oldCustomer =customerRepositary.getById(id);
        if(oldCustomer==null){
            throw new ApiException("Customer Not found !");
        }
        else{
           oldCustomer.setName(customer.getName());
           oldCustomer.setPhoneNumber(customer.getPhoneNumber());
           oldCustomer.setEmail(customer.getEmail());
           customerRepositary.save(oldCustomer);
        }}

    public void deleteCustomer(Integer id)
    {
        Customer oldCustomer =customerRepositary.getById(id);

        if(oldCustomer==null){
            throw new ApiException("customer Not found !");
        }
        else
            customerRepositary.deleteById(id);

    }


    }




