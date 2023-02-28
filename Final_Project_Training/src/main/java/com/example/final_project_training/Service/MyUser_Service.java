package com.example.final_project_training.Service;

import com.example.final_project_training.Exception.ApiException;
import com.example.final_project_training.Model.Customer;
import com.example.final_project_training.Model.MyUser;
import com.example.final_project_training.Repositary.Customer_Repository;
import com.example.final_project_training.Repositary.MyUser_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUser_Service {
    private final MyUser_Repository myUserRepository;
    private final Customer_Repository customerRepository;

    public List<MyUser> getUser() {
        return myUserRepository.findAll();
    }

    public void addUser(MyUser myUser) {
        myUserRepository.save(myUser);
    }

    public void updateUser(Integer id, MyUser newUser) {
        MyUser oldUser = myUserRepository.findMyUserById(id);
        if (oldUser == null) {
            throw new ApiException("User not found");
        }
        oldUser.setUsername(newUser.getUsername());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setRole(newUser.getRole());
        myUserRepository.save(oldUser);
    }

    public void deleteUser(Integer id) {
        MyUser user = myUserRepository.findMyUserById(id);
        if (user == null) {
            throw new ApiException("User Not found");
        }
        // myUserRepository.deleteById(id);
        myUserRepository.delete(user);
    }

    public void register(MyUser myUser){
        myUser.setRole("Admin");
        String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        myUserRepository.save(myUser);
    }





/*
    public void updateUserCustomer(MyUserCustomerDTO myUserCustomerDTO){
        Customer customer=customerRepository.findCustomerById(myUserCustomerDTO.getMyUser_id());
        if(customer==null)
            throw new ApiException("customer not found");
        customer.setName(myUserCustomerDTO.getName());
        customer.setPhone_number(myUserCustomerDTO.getPhone_number());
        customer.setAge(myUserCustomerDTO.getAge());
        customer.setLength(myUserCustomerDTO.getLength());
        customer.setWeight(myUserCustomerDTO.getWeight());
        customer.setHealth_problem(myUserCustomerDTO.getHealth_problem());
        customer.setCity(myUserCustomerDTO.getCity());
        customer.setAddress(myUserCustomerDTO.getAddress());
        customer.setEmail(myUserCustomerDTO.getEmail());
        customer.setGender(myUserCustomerDTO.getGender());
        customerRepository.save(customer);



    }


    public void deleteUserCustomer(Integer id)
    {
        Customer customer=customerRepository.findCustomerById(id);
        if(customer==null)
            throw new ApiException("customer not found");
        customerRepository.delete(customer);

    }*/
}
