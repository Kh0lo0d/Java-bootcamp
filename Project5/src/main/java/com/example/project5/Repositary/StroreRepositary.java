package com.example.project5.Repositary;

import com.example.project5.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StroreRepositary extends JpaRepository<Store,Integer> {
    Store findStoreById(Integer id);
}
