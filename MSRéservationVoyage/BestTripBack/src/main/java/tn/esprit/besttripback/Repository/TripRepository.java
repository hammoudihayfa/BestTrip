package tn.esprit.besttripback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.besttripback.Entity.Trip;

public interface TripRepository extends JpaRepository<Trip,Long> {
}
