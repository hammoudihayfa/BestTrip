package com.helene.besttrip.service;

import com.helene.besttrip.entities.Groupe;
import com.helene.besttrip.repositry.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupeService {



        @Autowired
        private GroupeRepository groupeRepository;

        // Create
        public Groupe creerGroupe(Groupe groupe) {
            return groupeRepository.save(groupe);
        }

        // Read
        public List<Groupe> lireTousLesGroupes() {
            return groupeRepository.findAll();
        }

        public Optional<Groupe> lireGroupeParId(Long id) {
            return groupeRepository.findById(id);
        }

        // Update
        public Groupe mettreAJourGroupe(Long id, Groupe detailsGroupe) {
            Groupe groupe = groupeRepository.findById(id).orElseThrow(() -> new RuntimeException("Groupe non trouvé"));
            groupe.setNom(detailsGroupe.getNom());
            groupe.setDescription(detailsGroupe.getDescription());
            groupe.setDestination(detailsGroupe.getDestination());
            groupe.setDateDebut(detailsGroupe.getDateDebut());
            groupe.setDateFin(detailsGroupe.getDateFin());
            groupe.setConfidentialite(detailsGroupe.getConfidentialite());
            groupe.setCapacite(detailsGroupe.getCapacite());
            return groupeRepository.save(groupe);
        }

        // Delete
        public void supprimerGroupe(Long id) {
            groupeRepository.deleteById(id);
        }
    }


