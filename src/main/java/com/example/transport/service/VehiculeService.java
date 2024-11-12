package com.example.transport.service;


import com.example.transport.model.Vehicule;
import com.example.transport.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService {
    @Autowired
    private VehiculeRepository repository;

    public List<Vehicule> getAllVehicules() {
        return repository.findAll();
    }

    public Optional<Vehicule> getVehiculeById(Long id) {
        return repository.findById(id);
    }

    public Vehicule addVehicule(Vehicule vehicule) {
        return repository.save(vehicule);
    }

    public Vehicule updateVehicule(Long id, Vehicule vehicule) {
        vehicule.setId(id);
        return repository.save(vehicule);
    }

    public void deleteVehicule(Long id) {
        repository.deleteById(id);
    }
}
