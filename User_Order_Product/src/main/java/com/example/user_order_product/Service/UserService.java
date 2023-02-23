package com.example.user_order_product.Service;

import com.example.user_order_product.Exception.ApiExceptin;
import com.example.user_order_product.Model.User;
import com.example.user_order_product.Repositary.UserRepsitary;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

private final UserRepsitary userRepsitary;
    public List getAllUser(){
        return userRepsitary.findAll();
    }

    public void addNewUser(User user){
        userRepsitary.save(user);
    }

    public void updateUser(Integer id,User user)
    {
        User oldUser =userRepsitary.getById(id);
        if(oldUser==null){
            throw new ApiExceptin("user Not found !");
        }
        else{
            oldUser.setName(user.getName());
            oldUser.setPassword(user.getPassword());
            oldUser.setRole(user.getRole());
            userRepsitary.save(oldUser);
        }}


    public void deleteUser(Integer id)
    {
        User oldUser =userRepsitary.getById(id);

        if(oldUser==null){
            throw new ApiExceptin("user Not found !");
        }
        else
            userRepsitary.deleteById(id);

    }

    public User Get_User(Integer id)
    {
        User user=userRepsitary.findUserById(id);
        if (user == null) {
            throw new ApiExceptin("user Not found !");    }
        else
            return user;}

    public void register(User user) {
        String hashedPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepsitary.save(user);
    }



}
