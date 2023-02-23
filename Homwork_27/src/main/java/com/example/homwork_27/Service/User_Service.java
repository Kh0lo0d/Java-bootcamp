package com.example.homwork_27.Service;

import com.example.homwork_27.Exception.ApiException;
import com.example.homwork_27.Model.Blog;
import com.example.homwork_27.Model.User;
import com.example.homwork_27.Repositary.BlogRepositry;
import com.example.homwork_27.Repositary.UserRepsitary;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class User_Service {
private final UserRepsitary userRepsitary;
private final BlogRepositry blogRepositry;
    public List<User> getAllUsers(){
        return userRepsitary.findAll();
    }
    public User getUser(Integer id){
        User user=userRepsitary.findUserById(id);
        if (user==null){
            throw new ApiException("User Not Found!");
        }
        return user;
    }
    public void addUser(User newUser){
        String hashedPassword=new BCryptPasswordEncoder().encode(newUser.getPassword());
        newUser.setPassword(hashedPassword);
        userRepsitary.save(newUser);
    }

    public void deleteUser(Integer id){
        User user=userRepsitary.findUserById(id);
        if(user==null){
            throw new ApiException("User Not Found");
        }
        userRepsitary.delete(user);
    }


    public void updateUser(User newUser, Integer id){
        User oldUser=userRepsitary.findUserById(id);

        newUser.setId(id);
        newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));

        userRepsitary.save(newUser);
    }

    public void register(User user) {
        String hashedPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepsitary.save(user);
    }





}
