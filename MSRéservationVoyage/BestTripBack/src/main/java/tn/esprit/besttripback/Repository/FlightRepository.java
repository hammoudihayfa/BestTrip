package tn.esprit.besttripback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.besttripback.Entity.Flight;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {
    List<Flight> findByDepartureCityAndArrivalCity(String departureCity, String arrivalCity);
    List<Flight> findByTripIdTrip(Long idTrip);


}
