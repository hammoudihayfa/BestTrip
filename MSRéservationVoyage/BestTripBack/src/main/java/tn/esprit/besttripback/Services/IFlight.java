package tn.esprit.besttripback.Services;

import tn.esprit.besttripback.Entity.Flight;

import java.util.List;
import java.util.Optional;

public interface IFlight {
    List<Flight> getAllFlights();
    Optional<Flight> getFlightById(Long idFlight);
    Flight createFlight(Flight flight);
    Flight updateFlight(Long idFlight, Flight flightDetails);
    void deleteFlight(Long idFlight);
    public List<Flight> findFlights(String departureCity, String arrivalCity);
    public List<Flight> getFlightsByTripId(Long idTrip);

}
