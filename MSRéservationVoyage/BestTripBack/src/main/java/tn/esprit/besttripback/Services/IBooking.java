package tn.esprit.besttripback.Services;

import tn.esprit.besttripback.Entity.Booking;

import java.util.List;
import java.util.Optional;

public interface IBooking {
     Booking createBooking(Booking booking);
    List<Booking> getAllBookings() ;

    Optional<Booking> getBookingById(Long idBooking) ;

     void deleteBooking(Long idBooking) ;
     List<Booking> getBookingDetails(Long idTrip);
    void bookTrip(Long idTrip, Long idPass);
}
