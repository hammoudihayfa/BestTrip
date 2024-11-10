package tn.esprit.besttripback.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.besttripback.Entity.Seat;
import tn.esprit.besttripback.Repository.SeatRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class SeatService implements ISeat{
    private SeatRepository seatRepository;
    @Override
    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Seat getSeatById(Long idSeat) {
        return seatRepository.findById(idSeat).orElse(null);
    }

    @Override
    public void deleteSeat(Long idSeat) {
    seatRepository.deleteById(idSeat);
    }
}
