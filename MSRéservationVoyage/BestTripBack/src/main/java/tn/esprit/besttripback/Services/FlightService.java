package tn.esprit.besttripback.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.besttripback.Entity.Flight;
import tn.esprit.besttripback.Repository.FlightRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightService implements IFlight {
    private FlightRepository flightRepository;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();   }

    @Override
    public Optional<Flight> getFlightById(Long idFlight) {
        return flightRepository.findById(idFlight);
    }

    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(Long idFlight, Flight flightDetails) {

        Flight flight = flightRepository.findById(idFlight)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        flight.setDepartureCity(flightDetails.getDepartureCity());
        flight.setArrivalCity(flightDetails.getArrivalCity());
        flight.setDepartureTime(flightDetails.getDepartureTime());
        flight.setArrivalTime(flightDetails.getArrivalTime());

        return flightRepository.save(flight);
    }


    @Override
    public void deleteFlight(Long idFlight) {
     flightRepository.deleteById(idFlight);
    }

    @Override
    public List<Flight> findFlights(String departureCity, String arrivalCity) {
        return flightRepository.findByDepartureCityAndArrivalCity(departureCity, arrivalCity);
    }

    @Override
    public List<Flight> getFlightsByTripId(Long idTrip) {
        return flightRepository.findByTripIdTrip(idTrip);
    }
}
