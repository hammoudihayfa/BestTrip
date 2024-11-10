package tn.esprit.besttripback.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.besttripback.Entity.Trip;
import tn.esprit.besttripback.Repository.TripRepository;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class TripService implements ITrip{
    private TripRepository tripRepository;


    @Override
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Optional<Trip> getTripById(Long idTrip) {
        return tripRepository.findById(idTrip);
    }

    @Override
    public Trip updateTrip(Long idTrip, Trip tripDetails) {
        Trip trip = tripRepository.findById(idTrip).orElseThrow(); // Ajoutez un traitement d'erreur approprié
        trip.setDestination(tripDetails.getDestination());
        trip.setStartDate(tripDetails.getStartDate());
        trip.setEndDate(tripDetails.getEndDate());
        // Mettez à jour d'autres attributs si nécessaire
        return tripRepository.save(trip);
    }

    @Override
    public void deleteTrip(Long idTrip) {
     tripRepository.deleteById(idTrip);
    }
}
