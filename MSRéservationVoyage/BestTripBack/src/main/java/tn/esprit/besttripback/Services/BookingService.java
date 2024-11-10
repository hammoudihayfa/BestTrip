package tn.esprit.besttripback.Services;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import tn.esprit.besttripback.Entity.Booking;
import tn.esprit.besttripback.Entity.Passenger;
import tn.esprit.besttripback.Event.BookingEvent;
import tn.esprit.besttripback.Repository.BookingRepository;
import tn.esprit.besttripback.Repository.PassengerRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookingService implements IBooking {
    private BookingRepository bookingRepository;
    private FlightService flightService;
    private final ApplicationEventPublisher publisher;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Long idBooking) {
        return bookingRepository.findById(idBooking);
    }

    @Override
    public void deleteBooking(Long idBooking) {
     bookingRepository.deleteById(idBooking);
    }



    public List<Booking> getBookingDetails(Long idTrip) {
        return bookingRepository.findByTrip_idTrip(idTrip);
    }

    @Override
    public void bookTrip(Long idTrip, Long idPass) {
        System.out.println("Réservation du voyage ID : " + idTrip + " pour le passager ID : " + idPass);
        publisher.publishEvent(new BookingEvent(this, idTrip, idPass, "Votre voyage a été réservé avec succès !"));

    }
}
