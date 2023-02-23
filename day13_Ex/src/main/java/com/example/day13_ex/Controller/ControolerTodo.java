package com.example.day13_ex.Controller;

import com.example.day13_ex.Pojo.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;


@RestController
@RequestMapping("api/v1")
public class ControolerTodo {

   ArrayList<Todo> todos = new ArrayList<>();


   @PostMapping("/create")
   public String addTodo(@RequestBody Todo todo) {

      todos.add(todo);

      return "A new object has been created";
   }

   @GetMapping("/Display")
   public ArrayList<Todo> getTodo() {

      return todos;
   }

   @PutMapping("/update/{index}")
   public Todo udateTodo(@PathVariable int index, @RequestBody Todo todo) {
      todos.set(index, todo);
      return todo;
   }

   @PutMapping("/change/{Id}")
   public String udateSTatue(@PathVariable String Id) {

      for (int i = 0; i < todos.size(); i++) {
         if(todos.get(i).getID()==Id) {
            if (todos.get(i).getStatus()=="done"){
               todos.get(i).setStatus("not done");
               System.out.println("not done");}

            else{
               todos.get(i).setStatus(" done");
               System.out.println(" done");}

         }
      }
      return " done change";

   }

   @PutMapping("/search/{title}")
   public Todo Serch(@PathVariable String title) {

      for (int i = 0; i < todos.size(); i++) {


         if (todos.get(i).getTitle().equals(title))
            return todos.get(i);


      }
      return null;


   }

   @DeleteMapping("/delete/{index}")
   public String deleteTodo(@PathVariable int index)
   {
      todos.remove(index);
      return"object has been deleted";
   }



}

















