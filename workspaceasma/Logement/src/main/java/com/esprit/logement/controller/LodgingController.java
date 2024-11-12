package com.esprit.logement.controller;

import com.esprit.logement.entity.Lodging;
import com.esprit.logement.service.LodgingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lodgings")
@CrossOrigin(origins = "http://localhost:4200")
public class LodgingController {

    @Autowired
    private LodgingService lodgingService;

    // Add a lodging
    @PostMapping
    public ResponseEntity<Lodging> addLodging(@RequestBody Lodging lodging) {
        Lodging createdLodging = lodgingService.addLodging(lodging);
        return new ResponseEntity<>(createdLodging, HttpStatus.CREATED);
    }

    // Get all lodgings
    @GetMapping
    public ResponseEntity<List<Lodging>> getAllLodgings() {
        List<Lodging> lodgings = lodgingService.getAll();
        return new ResponseEntity<>(lodgings, HttpStatus.OK);
    }

    // Update a lodging by ID
    @PutMapping("/{id}")
    public ResponseEntity<Lodging> updateLodging(@PathVariable int id,  @RequestBody Lodging newLodging) {
        Lodging updatedLodging = lodgingService.updateLodging(id, newLodging);
        return updatedLodging != null ? new ResponseEntity<>(updatedLodging, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a lodging by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLodging(@PathVariable int id) {
        String response = lodgingService.deleteLodging(id);
        return response != null ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Lodging not found", HttpStatus.NOT_FOUND);
    }
    // Display hello message
    @GetMapping("/hello")
    public ResponseEntity<String> getGreeting() {
        return new ResponseEntity<>("Hello AsmaBestTrip", HttpStatus.OK);
    }
}
