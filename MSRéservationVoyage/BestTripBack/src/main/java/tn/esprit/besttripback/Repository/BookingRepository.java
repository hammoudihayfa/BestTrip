package tn.esprit.besttripback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.besttripback.Entity.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByIdFlightIn(List<Long> flightIds);
    List<Booking> findByTrip_idTrip(Long idTrip);
}
