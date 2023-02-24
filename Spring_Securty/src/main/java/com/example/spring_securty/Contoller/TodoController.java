package com.example.spring_securty.Contoller;

import com.example.spring_securty.Model.MyUser;
import com.example.spring_securty.Model.Todo;
import com.example.spring_securty.Service.TodoService;
import com.example.spring_securty.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/todo")
@RestController
@RequiredArgsConstructor
public class TodoController {
    private TodoService todoService;

    @GetMapping("/get")
    public ResponseEntity<List<Todo>> getTodos(@AuthenticationPrincipal MyUser myUser){
        // return ResponseEntity.status(200).body(todoService.getTodos(myUser.getId()));
        return ResponseEntity.status(200).body(todoService.getTodos());
    }

    @PostMapping("/add")
    public ResponseEntity <Response> addTodos(@AuthenticationPrincipal MyUser myUser, @RequestBody Todo todo){
        todoService.addTodo(myUser.getId(), todo);
        return ResponseEntity.status(201).body(new Response("New Todo added !",201));
    }

    @DeleteMapping("delete/{todoId}")
    public ResponseEntity <Response> addTodos(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer todoId){
        todoService.removeTodo(myUser.getId(),todoId);
        return ResponseEntity.status(200).body(new Response("Todo deleted !",200));
    }

    @PutMapping("/update/{todoId}")
    public ResponseEntity updateTodos( @PathVariable Integer todoId,@AuthenticationPrincipal MyUser myUser, @RequestBody Todo todo) {
        todoService.updateTodo(todoId,todo);
        return ResponseEntity.status(200).body("myUser updated");

    }
}
