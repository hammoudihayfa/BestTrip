package com.helene.besttrip.RC;

import com.helene.besttrip.entities.Itineraire;
import com.helene.besttrip.service.ItineraireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/itineraires")
public class ItineraireController {

        private final ItineraireService itineraireService;

        @Autowired
        public ItineraireController(ItineraireService itineraireService) {
            this.itineraireService = itineraireService;
        }

        // Créer un nouvel itinéraire
        @PostMapping
        public ResponseEntity<Itineraire> createItineraire(@RequestBody Itineraire itineraire) {
            Itineraire savedItineraire = itineraireService.createItineraire(itineraire);
            return ResponseEntity.ok(savedItineraire);
        }

        // Récupérer un itinéraire par ID
        @GetMapping("/{id}")
        public ResponseEntity<Itineraire> getItineraireById(@PathVariable Long id) {
            Itineraire itineraire = itineraireService.getItineraireById(id);
            return ResponseEntity.ok(itineraire);
        }

        // Récupérer tous les itinéraires
        @GetMapping
        public ResponseEntity<List<Itineraire>> getItineraireParGroupe(@PathVariable Long groupeId) {
            List<Itineraire> itineraires = itineraireService.getItinerairesParGroupe(groupeId);
            return ResponseEntity.ok(itineraires);
        }

        // Mettre à jour un itinéraire existant
        @PutMapping("/{id}")
        public ResponseEntity<Itineraire> updateItineraire(@PathVariable Long id, @RequestBody Itineraire itineraireDetails) {
            Itineraire updatedItineraire = itineraireService.updateItineraire(id, itineraireDetails);
            return ResponseEntity.ok(updatedItineraire);
        }

        // Supprimer un itinéraire
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteItineraire(@PathVariable Long id) {
            itineraireService.supprimerItineraire(id);
            return ResponseEntity.noContent().build();
        }
    }


