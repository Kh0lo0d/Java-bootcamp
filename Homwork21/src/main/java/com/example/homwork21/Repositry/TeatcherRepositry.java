package com.example.homwork21.Repositry;

import com.example.homwork21.Model.Teatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeatcherRepositry extends JpaRepository<Teatcher,Integer> {

}
