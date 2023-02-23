package com.example.homwork_27.Repositary;

import com.example.homwork_27.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepsitary extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    User findUserByUsername(String name);

}
