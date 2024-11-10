package tn.esprit.besttripback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.besttripback.Entity.Passenger;

import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
    List<Passenger> findByTripId (Long idTrip);
}
