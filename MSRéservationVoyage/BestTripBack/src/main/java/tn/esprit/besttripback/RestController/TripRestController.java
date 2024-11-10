package tn.esprit.besttripback.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.besttripback.Entity.Trip;
import tn.esprit.besttripback.Services.TripService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/trips")
public class TripRestController {
    private TripService tripService;


    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long idTrip) {
        return tripService.getTripById(idTrip)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long idTrip, @RequestBody Trip tripDetails) {
        return ResponseEntity.ok(tripService.updateTrip(idTrip, tripDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long idTrip) {
        tripService.deleteTrip(idTrip);
        return ResponseEntity.noContent().build();
    }
}
