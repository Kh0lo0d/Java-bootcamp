package com.example.final_project_training.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MyUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(30) not null unique")
    private String username;
    //@Column(columnDefinition = "varchar(6) not null unique")
    private String password;

    @Column(columnDefinition = "varchar(30) not null check (role= 'Customer' or role= 'Coach' or role='Admin')")
    private String role;

    //@OneToOne(cascade = CascadeType.ALL,mappedBy = "myUser")
    //@PrimaryKeyJoinColumn
    //private Customer customer;

   /* @OneToOne(cascade = CascadeType.ALL,mappedBy = "myUser")
    @PrimaryKeyJoinColumn
    private Coach coach;*/

    @OneToOne(mappedBy = "myUser",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    Customer customer;

   @OneToOne(mappedBy = "myUser",cascade = CascadeType.ALL)
   @PrimaryKeyJoinColumn
     Coach coach;

   //@OneToOne
 // @MapsId
  //@JsonIgnore
   //private Customer customer;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
