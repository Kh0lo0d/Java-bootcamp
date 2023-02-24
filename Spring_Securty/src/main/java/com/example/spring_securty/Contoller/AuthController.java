package com.example.spring_securty.Contoller;

import com.example.spring_securty.Model.MyUser;
import com.example.spring_securty.Service.AuthService;
import com.example.spring_securty.dto.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;



    @PostMapping("/register")
    public ResponseEntity<Response> register(@Valid @RequestBody MyUser myUser){
        authService.register(myUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("User registered !",201));
    }

    @PostMapping("/admin")
    public ResponseEntity<Response> admin(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Welcome back ADMIN",200));
    }

    @PostMapping("/user")
    public ResponseEntity<Response> user(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Welcome back user",200));
    }


    @PostMapping("/login")
    public ResponseEntity<Response> login(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Welcome back",200));
    }
}
