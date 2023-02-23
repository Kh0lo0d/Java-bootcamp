package com.example.demo.Repositry;

import com.example.demo.Model.CustomerDetalis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface DetalisRepositry extends JpaRepository<CustomerDetalis,Integer> {
}
