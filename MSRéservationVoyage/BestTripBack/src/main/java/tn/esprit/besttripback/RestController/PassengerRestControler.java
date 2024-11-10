package tn.esprit.besttripback.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.besttripback.Entity.Passenger;
import tn.esprit.besttripback.Services.PassengerService;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/passengers")
public class PassengerRestControler {
    private PassengerService passengerService;
    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        System.out.println("Received passenger: " + passenger);

        if (passenger.getNom() == null || passenger.getPrenom() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        try {
            Passenger createdPassenger = passengerService.createPassenger(passenger);
            return new ResponseEntity<>(createdPassenger, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error creating passenger: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {
        return passengerService.getPassengerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{idPass}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long idPass, @RequestBody Passenger passengerDetails) {
        Passenger updatedPassenger = passengerService.updatePassenger(idPass, passengerDetails);
        return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
    }
    @GetMapping("/food-preferences")
    public ResponseEntity<List<String>> getFoodPreferences() {
        List<String> foodPreferences = passengerService.getFoodPreferences();
        return new ResponseEntity<>(foodPreferences, HttpStatus.OK);
    }

    @GetMapping("/{idPass}/available-seats")
    public ResponseEntity<List<String>> getAvailableSeatsForPassenger(@PathVariable Long idPass) {
        List<String> availableSeats = passengerService.getAvailableSeatsForPassenger(idPass);
        return new ResponseEntity<>(availableSeats, HttpStatus.OK);
    }

}
