package com.example.user_order_product.Repositary;

import com.example.user_order_product.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepsitary extends JpaRepository<User,Integer> {
    User findUserById(Integer id);

    User findUserByUsername(String name);
}
