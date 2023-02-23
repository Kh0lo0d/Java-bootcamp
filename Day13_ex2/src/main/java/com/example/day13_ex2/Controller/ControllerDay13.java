package com.example.day13_ex2.Controller;

import com.example.day13_ex2.Pojo.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("api/v1")
public class ControllerDay13 {

   ArrayList<Todo>todos=new ArrayList<>();

    @PostMapping("/add")
    public String addCustomer(@RequestBody Todo todo) {

        todos.add(todo);

        return "A new customer has been added";
    }


    @GetMapping("/Get")
    public ArrayList<Todo> getTodo() {


        return todos;
    }
    @PutMapping("/update/{index}")
    public Todo udateCustomer(@PathVariable int index, @RequestBody Todo todo) {
        todos.set(index, todo);
        System.out.println(todo);
        return todo;
    }

    @PutMapping("/Deposit/{amount}")
    public String DepositMoney( @PathVariable int amount,@RequestBody Todo todo) {

       if(amount<=12000){
           double w=todo.getBalance()+amount;
           todo.setBalance(w);
           return "The balance after deposit :"+w;}
       else
           return "you can not deposit ";

        }

    @PutMapping("/Withdraw/{amount}")
    public String WithdrawMoney( @PathVariable int amount,@RequestBody Todo todo) {
double q= todo.getBalance();
        if(amount<=q){
            double w=todo.getBalance()-amount;
            todo.setBalance(w);
            return "The balance after withdraw : "+w;}
        else
            return "you can not  withdraw !!";

    }


    @DeleteMapping("/delete/{index}")
    public String deleteTodo(@PathVariable int index)
    {
        todos.remove(index);
        return"object of customer has been deleted";
    }







    }









