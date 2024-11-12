package com.helene.besttrip.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MembreGroupe {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "groupe_id")
        private Groupe groupe;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User utilisateur;

        private LocalDate dateAdhesion;
        private Role role;


    }


