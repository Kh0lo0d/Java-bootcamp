package com.example.project5.Controller;

import com.example.project5.Model.Location;
import com.example.project5.Model.Store;
import com.example.project5.Service.LocationSirvice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/location")
public class LocationController {
    private final LocationSirvice locationSirvice;
    @GetMapping("/get")
    public ResponseEntity getAllLocation() {
        List<Location> locations = locationSirvice.getAllLocation();
        return ResponseEntity.status(200).body(locations);

    }

    @PostMapping("/add")
    public ResponseEntity addNewLocation(@Valid @RequestBody Location location) {
       locationSirvice.addNewLocation(location);
        return ResponseEntity.status(200).body("location added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLocation(@PathVariable Integer id, @Valid @RequestBody Location location) {
        locationSirvice.updateLocation(id,location);
        return ResponseEntity.status(200).body("location updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLocation(@PathVariable Integer id) {
        locationSirvice.deleteLocation(id);
        return ResponseEntity.status(200).body("location deleted");
    }
}
