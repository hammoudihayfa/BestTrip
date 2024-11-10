package tn.esprit.besttripback.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.besttripback.Entity.Seat;
import tn.esprit.besttripback.Services.SeatService;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/seats")
public class SeatRestController {
    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        Seat createdSeat = seatService.createSeat(seat);
        return ResponseEntity.status(201).body(createdSeat);
    }

    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return ResponseEntity.ok(seats);
    }

    @GetMapping("/{idSeat}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long idSeat) {
        Seat seat = seatService.getSeatById(idSeat);
        return ResponseEntity.ok(seat);
    }

    @DeleteMapping("/{idSeat}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long idSeat) {
        seatService.deleteSeat(idSeat);
        return ResponseEntity.noContent().build();
    }
}
