package tn.esprit.besttripback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.besttripback.Entity.Seat;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Seat> findByTripId(Long idTrip);
}
