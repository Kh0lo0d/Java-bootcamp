package com.example.user_order_product.Repositary;

import com.example.user_order_product.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderReprositary extends JpaRepository<Orders,Integer> {
    Orders findOrdersById(Integer id);
    Orders findOrdersByUser(Integer id);
}
