package com.example.day14_ex.Controller;


import com.example.day14_ex.Pojo.Employees;
import com.example.demo.Api.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1")
public class EmployeesController {


    ArrayList<Employees> employees=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Employees>getEmployees()
    {

        return employees;
    }

    @PostMapping("/add")
    public ApiResponse addEmployee(@Valid @RequestBody Employees employ, Errors errors)
    {
        if(errors.hasErrors())
        {
            String message =errors.getFieldError().getDefaultMessage();
            return new com.example.demo.Api.ApiResponse(message);
        }

        employees.add(employ) ;
        return new com.example.demo.Api.ApiResponse("Employee added");


    }

    @PutMapping("/update/{index}")
    public ResponseEntity udateEmplpyee(@PathVariable int index, @RequestBody Employees empl, Errors errors) {
        if(errors.hasErrors())
        {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.set(index, empl);

        return ResponseEntity.status(200).body("User Updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEmployee(@PathVariable int index)
    {

        if(index==0 || index < employees.size() )
        {
        employees.remove(index);
        return new ApiResponse("object has been deleted");}
        else
            return new ApiResponse("Error, the index is not found !!! ");
    }



    @PutMapping("/applay/{id}")
    public com.example.demo.Api.ApiResponse chechAnnual(@PathVariable String id) {
        for (int i = 0; i < employees.size(); i++) {


            if (employees.get(i).getId().equals(id)) {
                if (employees.get(i).getAnnualLeave() > 0) {
                    int a = employees.get(i).getAnnualLeave() - 1;
                    employees.get(i).setAnnualLeave(a);
                    employees.get(i).setOnLeave(true);
                    return new com.example.demo.Api.ApiResponse (" annual leaves reduce ,it will  "+ employees.get(i).getAnnualLeave()+'\n'+
                            "Information of employee : "+(employees.get(i)) );
                } else {
                    return new com.example.demo.Api.ApiResponse("bad request , " +
                            "There is no balance in the annual leave");}

            }
        }
            return new com.example.demo.Api.ApiResponse("the id not found");}}
















