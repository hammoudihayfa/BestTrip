package tn.esprit.besttripback.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPass;
    private String nom;
    private String prenom;
    private String email;
    private int age;
    private String sex;
    @ElementCollection
    private List <String> foodPreferences;
    private String seatNumber;
    private Long tripId;


}
