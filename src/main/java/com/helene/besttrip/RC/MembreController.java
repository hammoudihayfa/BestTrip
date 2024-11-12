package com.helene.besttrip.RC;

import com.helene.besttrip.entities.MembreGroupe;
import com.helene.besttrip.entities.Role;
import com.helene.besttrip.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membres")
public class MembreController {

    @Autowired
    private MembreService membreGroupeService;

    // Ajouter un membre à un groupe
    @PostMapping
    public ResponseEntity<MembreGroupe> addMembreToGroupe(@RequestBody MembreGroupe membreGroupe) {
        MembreGroupe createdMembre = membreGroupeService.addMembreToGroupe(membreGroupe);
        return ResponseEntity.ok(createdMembre);
    }

    // Obtenir un membre par ID
    @GetMapping("/{id}")
    public ResponseEntity<MembreGroupe> getMembreGroupeById(@PathVariable Long id) {
        MembreGroupe membreGroupe = membreGroupeService.getMembreGroupeById(id);
        return ResponseEntity.ok(membreGroupe);
    }

    // Obtenir tous les membres d'un groupe spécifique
    @GetMapping("/groupe/{groupeId}")
    public ResponseEntity<List<MembreGroupe>> getMembresByGroupeId(@PathVariable Long groupeId) {
        List<MembreGroupe> membres = membreGroupeService.getMembresByGroupeId(groupeId);
        return ResponseEntity.ok(membres);
    }

    // Mettre à jour le rôle d'un membre dans un groupe
    @PutMapping("/{id}/role")
    public ResponseEntity<MembreGroupe> updateMembreRole(@PathVariable Long id, @RequestParam Role role) {
        MembreGroupe updatedMembre = membreGroupeService.updateMembreGroupe(id, role);
        return ResponseEntity.ok(updatedMembre);
    }

    // Supprimer un membre du groupe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembreGroupe(@PathVariable Long id) {
        membreGroupeService.deleteMembreGroupe(id);
        return ResponseEntity.noContent().build();
    }

    // Obtenir les membres par rôle dans un groupe
    @GetMapping("/role")
    public ResponseEntity<List<MembreGroupe>> getMembresByRoleDansGroupe(@RequestParam Role role) {
        List<MembreGroupe> membres = membreGroupeService.getMembresByRoleDansGroupe(role);
        return ResponseEntity.ok(membres);
    }
}
