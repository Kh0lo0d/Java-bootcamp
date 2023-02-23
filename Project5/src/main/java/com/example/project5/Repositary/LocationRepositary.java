package com.example.project5.Repositary;

import com.example.project5.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepositary extends JpaRepository<Location,Integer> {
    Location findLocationById(Integer id);
}
