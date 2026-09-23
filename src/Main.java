import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.OffsetDateTime;

public class Main {

    private static final Path BOOKINGS_FILE =
            Path.of("data", "tennis-court-bookings.json");

    public static void main(String[] args) {
        System.out.println("Tennis court booking application");

        Court court = new Court("court-1", "Court 1", "hard", false, true);
        Person person = new Person("person-1", "Max Mustermann", "max@example.com");
        BookingService bookingService = new BookingService();
        OffsetDateTime start = OffsetDateTime.parse("2026-09-24T16:00:00+02:00");
        OffsetDateTime end = OffsetDateTime.parse("2026-09-24T17:00:00+02:00");

        Booking booking = bookingService.createBooking(
                "booking-002", court, person, start, end);
        System.out.println("Booking created for " + booking.getPerson().getName()
                + " on " + booking.getCourt().getName());

        try {
            String bookingsJson = Files.readString(BOOKINGS_FILE);
            System.out.println(bookingsJson);
        } catch (IOException exception) {
            System.err.println("Could not read booking data from "
                    + BOOKINGS_FILE + ": " + exception.getMessage());
        }
    }
}
