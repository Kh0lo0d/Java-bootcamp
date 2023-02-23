package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/x")


public class Maing
{



    @GetMapping("/name")
    public String getMapping()
    {
        return "My name is kholood ";
    }

    @GetMapping("/age")
    public String getAge()
    {
        return "My age is 27: ";
    }
    @GetMapping("/check")
    public String CheckStatue()
    {
        return "Every thing Ok ";
    }

    @GetMapping("/health")
    public String getHealth()
    {
        return "Server health is up and running ";
    }









    }



