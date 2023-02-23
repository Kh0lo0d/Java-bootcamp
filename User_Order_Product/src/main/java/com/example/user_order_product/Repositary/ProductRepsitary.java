package com.example.user_order_product.Repositary;

import com.example.user_order_product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepsitary extends JpaRepository<Product,Integer> {
    Product findProductById(Integer id);
}
