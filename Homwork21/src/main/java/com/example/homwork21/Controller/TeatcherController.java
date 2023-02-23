package com.example.homwork21.Controller;

import com.example.homwork21.Model.Teatcher;
import com.example.homwork21.Servier.TeatcherServir;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teatcher")
public class TeatcherController {

    private final TeatcherServir teatcherServir;

    @GetMapping("/get")
    public ResponseEntity getAllTeatchers() {
        List<Teatcher> teatchers = teatcherServir.getAllTeatchers();
        return ResponseEntity.status(200).body(teatchers);

    }

    @PostMapping("/add")
    public ResponseEntity addTeatcher(@Valid @RequestBody Teatcher teatcher) {
        teatcherServir.addTeatcher((teatcher));

        return ResponseEntity.status(200).body("teacher added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeatcher(@PathVariable Integer id, @Valid @RequestBody Teatcher teatcher) {
     teatcherServir.updateTeatcher(id,teatcher);
            return ResponseEntity.status(200).body("teacher updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeatcher(@PathVariable Integer id) {

            teatcherServir.deleteTeatcher(id);
            return ResponseEntity.status(200).body("teacher deleted");


    }

}
