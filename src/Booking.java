import java.time.OffsetDateTime;
import java.util.Objects;

public class Booking {

    private final String id;
    private final Court court;
    private final Person person;
    private final OffsetDateTime start;
    private final OffsetDateTime end;
    private BookingStatus status;

    public Booking(String id, Court court, Person person,
                   OffsetDateTime start, OffsetDateTime end) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id must not be blank");
        }
        if (court == null || person == null || start == null || end == null) {
            throw new IllegalArgumentException("booking fields must not be null");
        }
        if (!start.isBefore(end)) {
            throw new IllegalArgumentException("start must be before end");
        }
        this.id = id;
        this.court = court;
        this.person = person;
        this.start = start;
        this.end = end;
        this.status = BookingStatus.CONFIRMED;
    }

    public Court getCourt() {
        return court;
    }

    public Person getPerson() {
        return person;
    }

    public OffsetDateTime getStart() {
        return start;
    }

    public OffsetDateTime getEnd() {
        return end;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void cancel() {
        status = BookingStatus.CANCELLED;
    }

    public boolean overlaps(OffsetDateTime requestedStart, OffsetDateTime requestedEnd) {
        return status == BookingStatus.CONFIRMED
                && start.isBefore(requestedEnd)
                && requestedStart.isBefore(end);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) other;
        return id.equals(booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
