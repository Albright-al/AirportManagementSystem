package airport;

/**
 * CLASS: Reservation
 * Tracks a passenger's booking for a specific flight.
 * Status: PENDING → CONFIRMED or CANCELLED
 */
public class Reservation {

    private String    reservationId;
    private Passenger passenger;
    private Flight    flight;
    private String    bookingDate;
    private String    status;     // PENDING | CONFIRMED | CANCELLED

    // ── Default Constructor ──────────────────────────────────────────────────
    public Reservation() {
        this.reservationId = "R000";
        this.bookingDate   = "2024-01-01";
        this.status        = "PENDING";
    }

    // ── Parameterized Constructor ────────────────────────────────────────────
    public Reservation(String reservationId, Passenger passenger,
                       Flight flight, String bookingDate) {
        this.reservationId = reservationId;
        this.passenger     = passenger;
        this.flight        = flight;
        this.bookingDate   = bookingDate;
        this.status        = "PENDING";
    }

    // ── Getters & Setters ────────────────────────────────────────────────────
    public String    getReservationId() { return reservationId; }
    public Passenger getPassenger()     { return passenger; }
    public Flight    getFlight()        { return flight; }
    public String    getBookingDate()   { return bookingDate; }
    public String    getStatus()        { return status; }

    public void setReservationId(String reservationId) { this.reservationId = reservationId; }
    public void setPassenger(Passenger passenger)      { this.passenger     = passenger; }
    public void setFlight(Flight flight)               { this.flight        = flight; }
    public void setBookingDate(String bookingDate)     { this.bookingDate   = bookingDate; }

    // ── Methods ──────────────────────────────────────────────────────────────
    public void confirmReservation() {
        this.status = "CONFIRMED";
        System.out.println("[RESERVATION] " + reservationId + " CONFIRMED for " + passenger.getFullName());
    }

    public void cancelReservation() {
        this.status = "CANCELLED";
        System.out.println("[RESERVATION] " + reservationId + " CANCELLED.");
    }

    public void updateReservation(String newDate) {
        this.bookingDate = newDate;
        System.out.println("[RESERVATION] " + reservationId + " updated to date: " + newDate);
    }

    @Override
    public String toString() {
        return "Reservation[" + reservationId + "] Passenger: " + passenger.getFullName()
                + " | Flight: " + flight.getFlightId()
                + " | Date: " + bookingDate
                + " | Status: " + status;
    }
}
