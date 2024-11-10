package tn.esprit.besttripback.Services;

import tn.esprit.besttripback.Entity.Seat;

import java.util.List;

public interface ISeat {
    Seat createSeat(Seat seat);
    List<Seat> getAllSeats();
    Seat getSeatById(Long idSeat);
    void deleteSeat(Long idSeat);
}
