package com.example.transport.controller;


import com.example.transport.model.Vehicule;
import com.example.transport.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {
    @Autowired
    private VehiculeService service;

    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return service.getAllVehicules();
    }

    @GetMapping("/{id}")
    public Optional<Vehicule> getVehiculeById(@PathVariable Long id) {
        return service.getVehiculeById(id);
    }

    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return service.addVehicule(vehicule);
    }

    @PutMapping("/{id}")
    public Vehicule updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        return service.updateVehicule(id, vehicule);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicule(@PathVariable Long id) {
        service.deleteVehicule(id);
    }
}
