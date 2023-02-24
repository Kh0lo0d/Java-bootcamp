package com.example.spring_securty.Service;

import com.example.spring_securty.Model.MyUser;
import com.example.spring_securty.Repositary.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final AuthRepository authRepository;


    public void register(MyUser myUser) {
        myUser.setRole("USER");
        String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        // authRepository.save(myUser);
        authRepository.save(myUser);

    }
}