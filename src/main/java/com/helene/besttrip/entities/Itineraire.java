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
public class Itineraire {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nomEtape;
        private String description;
        private LocalDate date;
        private Integer ordre;

        @ManyToOne
        @JoinColumn(name = "groupe_id")
        private Groupe groupe;




}
