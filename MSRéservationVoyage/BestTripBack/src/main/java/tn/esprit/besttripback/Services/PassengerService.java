package tn.esprit.besttripback.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.besttripback.Entity.Passenger;
import tn.esprit.besttripback.Entity.Seat;
import tn.esprit.besttripback.Repository.PassengerRepository;
import tn.esprit.besttripback.Repository.SeatRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PassengerService implements IPassenger{
    private PassengerRepository passengerRepository;
    private SeatRepository seatRepository;
    @Override
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Optional<Passenger> getPassengerById(Long idPass) {
        return passengerRepository.findById(idPass);
    }

    @Override
    public Passenger updatePassenger(Long idPass, Passenger passengerDetails) {
        Passenger passenger = passengerRepository.findById(idPass)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        passenger.setNom(passengerDetails.getNom());
        passenger.setPrenom(passengerDetails.getPrenom());
        passenger.setEmail(passengerDetails.getEmail());
        passenger.setAge(passengerDetails.getAge());
        passenger.setSex(passengerDetails.getSex());
        passenger.setFoodPreferences(passengerDetails.getFoodPreferences());
        passenger.setSeatNumber(passengerDetails.getSeatNumber());
        passenger.setTripId(passengerDetails.getTripId());
        return passengerRepository.save(passenger);

    }

    @Override
    public void deletePassenger(Long idPass) {
    passengerRepository.deleteById(idPass);
    }

    @Override
    public List<String> getFoodPreferences() {
        List<Passenger> passengers = passengerRepository.findAll();
        List<String> foodPreferences = new ArrayList<>();

        for (Passenger passenger : passengers) {
            foodPreferences.addAll(passenger.getFoodPreferences());
        }

        return foodPreferences;
    }

    @Override
    public List<String> getAvailableSeatsForPassenger(Long idPass) {

        Passenger passenger = passengerRepository.findById(idPass)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        List<Seat> allSeats = seatRepository.findByTripId(passenger.getTripId());

        List<String> occupiedSeats = new ArrayList<>();

        if (passenger.getSeatNumber() != null) {
            occupiedSeats.add(passenger.getSeatNumber());
        }

        List<String> availableSeats = new ArrayList<>();

        for (Seat seat : allSeats) {
            if (!occupiedSeats.contains(seat.getSeatNumber())) {
                availableSeats.add(seat.getSeatNumber());
            }
        }

        return availableSeats;
    }

}
