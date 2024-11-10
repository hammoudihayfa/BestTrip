package tn.esprit.besttripback.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrip;
    private String destination;
    private String startDate;
    private String endDate;
    @OneToMany(mappedBy = "trip")
    private List<Flight> flights;
}
