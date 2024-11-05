package com.esprit.logement.service;
import com.esprit.logement.entity.Lodging;
import com.esprit.logement.repository.LodgingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LodgingService {
    @Autowired
    private LodgingRepository lodgingRepository;

    public Lodging addLodging(Lodging lodging) {
        return lodgingRepository.save(lodging);
    }

    public List<Lodging> getAll() {
        return lodgingRepository.findAll();
    }

    public Lodging updateLodging(int id, Lodging newLodging) {
        return lodgingRepository.findById(id)
                .map(existingLodging -> {
                    existingLodging.setName(newLodging.getName());
                    existingLodging.setAddress(newLodging.getAddress());
                    existingLodging.setPricePerNight(newLodging.getPricePerNight());
                    return lodgingRepository.save(existingLodging);
                }).orElse(null);
    }

    public String deleteLodging(int id) {
        if (lodgingRepository.existsById(id)) {
            lodgingRepository.deleteById(id);
            return "Lodging deleted";
        } else {
            return "Lodging not found";
        }
    }

}
