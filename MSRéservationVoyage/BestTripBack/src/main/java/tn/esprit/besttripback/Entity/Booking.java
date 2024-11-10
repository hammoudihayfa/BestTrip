package tn.esprit.besttripback.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBooking;
    private Long idPass;
    private Long idFlight;
    private String seatNumber;
    @ManyToOne
    @JoinColumn(name = "idTrip")
    private Trip trip;

}
