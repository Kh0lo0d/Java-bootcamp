package com.example.final_project_training;

import com.example.final_project_training.Controller.Reviews_Controller;
import com.example.final_project_training.Exception.ApiException;
import com.example.final_project_training.Model.Reviews;
import com.example.final_project_training.Service.Reviews_Service;
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

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = Reviews_Controller.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class ReviewsControllerTest {

            @MockBean
            Reviews_Service reviewsService;

    @Autowired
    MockMvc mockMvc;

    Reviews review1, review2, review3;

    ApiException apiResponse;

    List<Reviews> reviews, reviewsList;

    @BeforeEach
    public void setUp() {
        review1 = new Reviews(null, 10, "Very Good", null);
        review2 = new Reviews(2, 7, "Good", null);
        reviews = Arrays.asList(review1);
        reviewsList = Arrays.asList(review2);
    }
    @Test
    public void getReviews() throws Exception{
        Mockito.when(reviewsService.getReviews()).thenReturn(reviews);

        mockMvc.perform(get("/api/v1/review/get"))
                .andExpect(status().isOk());
    }

    @Test
    public void DeleteReviews() throws Exception{
        mockMvc.perform(delete("/api/v1/review/delete/{id}",review2.getId()))
                .andExpect(status().isOk());

    }
}
