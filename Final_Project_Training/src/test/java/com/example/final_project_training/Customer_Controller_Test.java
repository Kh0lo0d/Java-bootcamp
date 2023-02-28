package com.example.final_project_training;

import com.example.final_project_training.Controller.Customer_Controller;
import com.example.final_project_training.Service.Customer_Service;
import com.example.final_project_training.dto.ApiResponse;
//import com.example.final_project_training.Api.ApiResponse;

import com.example.final_project_training.Controller.Coach_Controller;
import com.example.final_project_training.Model.MyUser;
import com.example.final_project_training.Model.Customer;
import com.example.final_project_training.Service.Customer_Service;

import com.example.final_project_training.dto.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = Customer_Controller.class , excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class Customer_Controller_Test {

    @MockBean
    Customer_Service customerService;

    @Autowired
    MockMvc mockMvc;

    Customer customer1, customer2, customer3;
    MyUser myUser;

    ApiResponse apiResponse;

    List<Customer> customers, customerList;

    @BeforeEach
    void setUp() {
        myUser = new MyUser(1, "Ahmed", "123456", "Customer", customer1, null);
        customer1=new Customer(null,"Nasser","Male","456554545","sal@hotmail.com",40,155,70,"Not found","Makkah","ABCDCD",null,myUser);
        customer2=new Customer(2,"Majed","Male","455556565656","koko@hotmail.com",30,180,150,"not found","Ryiadh","WWWWWWWW",null,myUser);
        customer3=new Customer(null,"Dalia","Female","45545454545","klklkl@hotmail.com",25,180,55,"Not found","Tubook","erewew",null,myUser);

        customers = Arrays.asList(customer1);
        customerList = Arrays.asList(customer2);


    }

  /*  @Test
    public void deleteCustomer() throws Exception {
        mockMvc.perform(delete("/api/v1/customer/delete/{id}", customer1.getId()))
                .andExpect(status().isOk());}


    @Test
    public void GetAllCustomer() throws Exception {
        Mockito.when(customerService.getCustomer()).thenReturn(customers);
        mockMvc.perform(get("/api/v1/customer/get"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Nasser"));
    }

    @Test
    public void addCustomer() throws  Exception {
        mockMvc.perform(post("/api/v1/customer/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content( new ObjectMapper().writeValueAsString(customer2)))
                .andExpect(status().isOk());

    }*/
}