package com.example.final_project_training.Repositary;

import com.example.final_project_training.Model.Order_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface Order_Repositary extends JpaRepository<Order_table,Integer> {
    Order_table findOrder_tableById(Integer Id);
    Order_table findOrder_tableByStatus(String status);

    List<Order_table> findOrder_tableByCoachId(Integer id);

    Order_table findOrter_tableByCustomerId(Integer id);

}
