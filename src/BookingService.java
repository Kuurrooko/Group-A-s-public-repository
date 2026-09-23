import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookingService {

    private final List<Booking> bookings = new ArrayList<>();

    public Booking createBooking(String id, Court court, Person person,
                                 OffsetDateTime start, OffsetDateTime end) {
        if (!court.isActive()) {
            throw new IllegalArgumentException("court is not active");
        }
        if (!isAvailable(court, start, end)) {
            throw new IllegalArgumentException("court is already booked for this time");
        }

        Booking booking = new Booking(id, court, person, start, end);
        bookings.add(booking);
        return booking;
    }

    public boolean isAvailable(Court court, OffsetDateTime start, OffsetDateTime end) {
        if (court == null || start == null || end == null || !start.isBefore(end)) {
            return false;
        }
        for (Booking booking : bookings) {
            if (booking.getCourt().equals(court) && booking.overlaps(start, end)) {
                return false;
            }
        }
        return true;
    }

    public List<Booking> getBookings() {
        return Collections.unmodifiableList(bookings);
    }
}
