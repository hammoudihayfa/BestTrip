package tn.esprit.besttripback.Services;

import tn.esprit.besttripback.Entity.Passenger;

import java.util.List;
import java.util.Optional;

public interface IPassenger {
    Passenger createPassenger(Passenger passenger);
    List<Passenger> getAllPassengers();
    Optional<Passenger> getPassengerById(Long idPass);
    public Passenger updatePassenger(Long idPass, Passenger passengerDetails);
    void deletePassenger(Long idPass);

    List<String> getFoodPreferences();
    List<String> getAvailableSeatsForPassenger(Long idPass);
}
