package tn.esprit.besttripback.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.besttripback.Entity.Booking;
import tn.esprit.besttripback.Entity.Trip;
import tn.esprit.besttripback.Services.BookingService;
import tn.esprit.besttripback.Services.TripService;
import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookings")
public class BookingRestController {
    private BookingService bookingService;
    private  TripService tripService;
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/bookings/selectedTrip/{idTrip}")
    public ResponseEntity<Trip> getSelectedTripDetails(@PathVariable Long idTrip) {
        return tripService.getTripById(idTrip)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/bookings/trips/{idTrip}")
    public ResponseEntity<List<Booking>> getBookingDetailsByTripId(@PathVariable Long idTrip) {
        List<Booking> bookings = bookingService.getBookingDetails(idTrip);
        if (bookings.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookings);
    }
    @GetMapping("/{idTrip}/{idPass}")
    public String bookTrip(@PathVariable Long idTrip, @PathVariable Long idPass) {
        bookingService.bookTrip(idTrip, idPass);
        return "Réservation effectuée pour le voyage " + idTrip + " et le passager " + idPass;
    }

}

