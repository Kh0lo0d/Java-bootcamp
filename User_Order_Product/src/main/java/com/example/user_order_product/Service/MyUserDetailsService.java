package com.example.user_order_product.Service;

import com.example.user_order_product.Model.User;
import com.example.user_order_product.Repositary.UserRepsitary;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepsitary userRepsitary;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepsitary.findUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("Wrong username or password");
        }
        return user;
    }



}
