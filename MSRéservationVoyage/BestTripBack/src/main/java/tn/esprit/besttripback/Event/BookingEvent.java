package tn.esprit.besttripback.Event;
import org.springframework.context.ApplicationEvent;

public class BookingEvent  extends ApplicationEvent {
    private Long tripId;
    private Long passengerId;
    private String message;

    public BookingEvent(Object source, Long tripId, Long passengerId, String message) {
        super(source);
        this.tripId = tripId;
        this.passengerId = passengerId;
        this.message = message;
    }

    public Long getTripId() {
        return tripId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public String getMessage() {
        return message;
    }
}
