package tn.esprit.besttripback.Listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import tn.esprit.besttripback.Event.BookingEvent;

@Component
public class BookingEventListener {
    @EventListener
    public void onBookingEvent(BookingEvent event) {
        // Traiter l'événement, par exemple en envoyant une notification ou en effectuant une autre action
        System.out.println("Notification : " + event.getMessage());

    }
}
