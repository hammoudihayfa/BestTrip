package com.helene.besttrip.service;

import com.helene.besttrip.entities.Itineraire;
import com.helene.besttrip.repositry.ItineraireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItineraireService {


        @Autowired
        private ItineraireRepository itineraireRepository;

        public Itineraire createItineraire(Itineraire itineraire) {
            return itineraireRepository.save(itineraire);
        }

        public Itineraire getItineraireById(Long id) {
            return itineraireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Itineraire not found"));
        }

        public List<Itineraire> getItinerairesParGroupe(Long groupeId) {
            return itineraireRepository.findByGroupeId(groupeId);
        }

        public Itineraire updateItineraire(Long id, Itineraire detailsItineraire) {
            Itineraire itineraire = itineraireRepository.findById(id).orElseThrow(() -> new RuntimeException("Itineraire non trouvé"));
            itineraire.setNomEtape(detailsItineraire.getNomEtape());
            itineraire.setDescription(detailsItineraire.getDescription());
            itineraire.setDate(detailsItineraire.getDate());
            itineraire.setOrdre(detailsItineraire.getOrdre());
            return itineraireRepository.save(itineraire);
        }

        public void supprimerItineraire(Long id) {
            itineraireRepository.deleteById(id);
        }
    }

