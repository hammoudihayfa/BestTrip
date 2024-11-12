package com.helene.besttrip.repositry;

import com.helene.besttrip.entities.Itineraire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItineraireRepository extends JpaRepository<Itineraire, Long> {
        List<Itineraire> findByGroupeId(Long groupeId);
    }


