package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Model.CustomerDetalis;
import com.example.demo.Repositry.DetalisRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalisService {

    private final DetalisRepositry detalisRepositry;
    public List getAllDetalis() {

        return detalisRepositry.findAll();
    }

    public void addDetalies(CustomerDetalis customerDetalis) {
        detalisRepositry.save(customerDetalis);


    }

    public boolean updateDetalies(Integer id,CustomerDetalis customerDetalis){

        CustomerDetalis oldDetalies=detalisRepositry.getById(id);
        if(oldDetalies==null){
            return false;}

        oldDetalies.setAge(customerDetalis.getAge());
        oldDetalies.setPhone_number(customerDetalis.getPhone_number());
        oldDetalies.setGender(customerDetalis.getGender());
        detalisRepositry.save(oldDetalies);
        return true;
    }
    public boolean deleteDetalies(Integer id) {
        CustomerDetalis oldDetalies=detalisRepositry.getById(id);
        if (oldDetalies == null) {
            return false;
        } else
            detalisRepositry.deleteById(id);
        return true;

    }
}
