package com.helene.besttrip.RC;

import com.helene.besttrip.entities.Groupe;
import com.helene.besttrip.service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groupes")
public class GroupeController {
        @Autowired
        private GroupeService groupeService;

        // Create Groupe
        @PostMapping
        public ResponseEntity<Groupe> creerGroupe(@RequestBody Groupe groupe) {
            Groupe nouveauGroupe = groupeService.creerGroupe(groupe);
            return ResponseEntity.status(HttpStatus.CREATED).body(nouveauGroupe);
        }

        // Read All Groupes
        @GetMapping
        public List<Groupe> lireTousLesGroupes() {
            return groupeService.lireTousLesGroupes();
        }

        // Read Groupe by ID
        @GetMapping("/{id}")
        public ResponseEntity<Groupe> lireGroupeParId(@PathVariable Long id) {
            return groupeService.lireGroupeParId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        // Update Groupe
        @PutMapping("/{id}")
        public ResponseEntity<Groupe> mettreAJourGroupe(@PathVariable Long id, @RequestBody Groupe detailsGroupe) {
            return ResponseEntity.ok(groupeService.mettreAJourGroupe(id, detailsGroupe));
        }

        // Delete Groupe
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> supprimerGroupe(@PathVariable Long id) {
            groupeService.supprimerGroupe(id);
            return ResponseEntity.noContent().build();
        }
    }


