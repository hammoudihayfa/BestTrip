package com.helene.besttrip.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private String destination;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private Confidentialite confidentialite;  // Assurez-vous que Confidentialite est une enum

    private Integer capacite;

    @ManyToOne
    private User administrateur;

    @OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL)
    private List<MembreGroupe> membres = new ArrayList<>();
}
