package tn.esprit.besttripback.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.besttripback.Entity.Flight;
import tn.esprit.besttripback.Services.FlightService;


import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/flights")
public class FlightRestController {

    private final FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flightDetails) {
        return ResponseEntity.ok(flightService.updateFlight(id, flightDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam String departureCity,
            @RequestParam String arrivalCity) {
        List<Flight> flights = flightService.findFlights(departureCity, arrivalCity);

        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(flights);
    }

    @GetMapping("/trips/{idTrip}")
    public ResponseEntity<List<Flight>> getFlightsByTripId(@PathVariable Long idTrip) {
        List<Flight> flights = flightService.getFlightsByTripId(idTrip);
        if (flights.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flights);
    }

}
