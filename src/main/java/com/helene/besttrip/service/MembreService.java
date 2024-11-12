package com.helene.besttrip.service;

import com.helene.besttrip.entities.MembreGroupe;
import com.helene.besttrip.entities.Role;
import com.helene.besttrip.repositry.MembreRepository;  // Assurez-vous que le package est correct
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembreService {
    @Autowired
    private MembreRepository membreGroupeRepository;

    // Ajouter un membre à un groupe
    public MembreGroupe addMembreToGroupe(MembreGroupe membreGroupe) {
        return membreGroupeRepository.save(membreGroupe);
    }

    // Récupérer un membre par ID
    public MembreGroupe getMembreGroupeById(Long id) {
        return membreGroupeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MembreGroupe non trouvé"));
    }

    // Récupérer tous les membres d'un groupe spécifique
    public List<MembreGroupe> getMembresByGroupeId(Long groupeId) {
        return membreGroupeRepository.findByGroupeId(groupeId);
    }

    // Mettre à jour le rôle d'un membre dans un groupe
    public MembreGroupe updateMembreGroupe(Long id, Role role) {
        MembreGroupe membreGroupe = membreGroupeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MembreGroupe non trouvé"));

        membreGroupe.setRole(role);
        return membreGroupeRepository.save(membreGroupe);
    }

    // Supprimer un membre du groupe
    public void deleteMembreGroupe(Long id) {
        membreGroupeRepository.deleteById(id);
    }

    // Récupérer les membres d'un groupe par rôle (ex: ADMIN, MEMBRE, INVITE)
    public List<MembreGroupe> getMembresByRoleDansGroupe(Role role) {
        return membreGroupeRepository.findByRole(role);
    }
}
