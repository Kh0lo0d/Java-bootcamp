package com.example.final_project_training;

import com.example.final_project_training.Controller.OrderController;
import com.example.final_project_training.Exception.ApiException;
import com.example.final_project_training.Model.Order_table;
import com.example.final_project_training.Service.OrderServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = OrderController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class OrderControllerTest {
/*
    @MockBean
    OrderServices orderServices;

    @Autowired
    MockMvc mockMvc;

    Order_table order1, order2, order3;

    ApiException apiResponse;

    List<Order_table> order, orterList;

    @BeforeEach
    public void setUp() {
        DateTimeFormatter df = DateTimeFormatter .ofPattern("MM/dd/yyyy");

        order1 =new Order_table(null, LocalDate.parse("02/02/2023" , df), LocalDate.parse("02/08/2023" , df), LocalTime.parse("10:11:00"), 200, "ACCEPT",(List)null,null, null);
        order2 =new Order_table(2, LocalDate.parse("02/02/2023" , df), LocalDate.parse("02/08/2023" , df), LocalTime.parse("10:11:00"), 200, "ACCEPT",(List)null,null, null);
        order = Arrays.asList(order1);
        orterList = Arrays.asList(order2);
    }
    @Test
    public void getOrders() throws Exception{
        Mockito.when(orderServices.getAllOrders()).thenReturn(order);

        mockMvc.perform(get("/api/v1/order/getAll-Order"))
                .andExpect(status().isOk());
    }

    @Test
    public void DeleteOrder() throws Exception{
        mockMvc.perform(delete("/api/v1/order/delete/{id}",order2.getId()))
                .andExpect(status().isOk());

    }
*/
}
