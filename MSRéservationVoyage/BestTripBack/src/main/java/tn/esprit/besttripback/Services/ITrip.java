package tn.esprit.besttripback.Services;

import tn.esprit.besttripback.Entity.Trip;

import java.util.List;
import java.util.Optional;

public interface ITrip {
    Trip createTrip(Trip trip);
    List<Trip> getAllTrips();
    Optional<Trip> getTripById(Long idTrip);
    Trip updateTrip(Long idTrip, Trip tripDetails);
    void deleteTrip(Long idTrip);
}
