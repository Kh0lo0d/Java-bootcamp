package com.example.final_project_training.Repositary;

import com.example.final_project_training.Model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reviews_Repository extends JpaRepository<Reviews, Integer> {
    Reviews findReviewsById(Integer id);

}
