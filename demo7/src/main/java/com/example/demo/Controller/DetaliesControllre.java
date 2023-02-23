package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.CustomerDetalis;
import com.example.demo.Service.DetalisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customerDetalies")
public class DetaliesControllre {

private final DetalisService detalisService;
    @GetMapping("/get")
    public ResponseEntity getAllDetalies()
    {
        List<CustomerDetalis> customerDetalis=detalisService.getAllDetalis();
        return ResponseEntity.status(200).body(customerDetalis);

    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody CustomerDetalis customerDetalis)
    {detalisService.addDetalies(customerDetalis);

        return ResponseEntity.status(200).body("detalies added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDetalies(@PathVariable Integer id, @Valid @RequestBody CustomerDetalis customerDetalis)
    {

boolean isUbdate=detalisService.updateDetalies(id,customerDetalis);

        if(isUbdate==true)
            return ResponseEntity.status(200).body("detalies updated");

        else

            return ResponseEntity.status(400).body("Wrong id");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDetalies(@PathVariable Integer id){
        boolean isDeleted= detalisService.deleteDetalies(id);
        if(isDeleted==true)
            return ResponseEntity.status(200).body("detalies deleted");
        else
            return ResponseEntity.status(400).body("Wrong id");

    }






}
