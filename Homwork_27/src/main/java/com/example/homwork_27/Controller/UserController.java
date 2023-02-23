package com.example.homwork_27.Controller;

import com.example.homwork_27.Model.User;
import com.example.homwork_27.Service.Blog_Service;
import com.example.homwork_27.Service.User_Service;
import com.example.homwork_27.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private  final User_Service userService;
    private final Blog_Service blogService;

    @GetMapping("/allUsers")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(userService.getUser(id));
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody @Valid User newUser, @AuthenticationPrincipal User auth){
        userService.updateUser(newUser , auth.getId());
        return ResponseEntity.status(200).body(new ApiResponse("User Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("User Deleted"));
    }

    @PostMapping("/{idBlog}/user/{idUser}")
    public ResponseEntity assignUserToBlog(@PathVariable Integer idBlog,@PathVariable Integer idUser)
    {
        blogService.assignUserToBlog(idBlog,idUser);
        return ResponseEntity.status(200).body(new ApiResponse("Blog assign"));

    }


    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody User newUser){
        userService.register(newUser);
        return ResponseEntity.status(201).body(new ApiResponse("User Created"));
    }



    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body(new ApiResponse("Logged in successfully"));
    }

}
