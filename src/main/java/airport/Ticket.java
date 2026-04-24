package airport;

// ============================================================
//  CLASS: Ticket
//  Links a Passenger to a Flight with seat and class info.
// ============================================================
public class Ticket {

    private String    ticketId;
    private Passenger passenger;   // "has-a" Passenger
    private Flight    flight;      // "has-a" Flight
    private String    seatNumber;
    private String    classType;   // Economy | Business | First
    private double    price;

    // ── Default Constructor ──────────────────────────────────────────────────
    public Ticket() {
        this.ticketId   = "T000";
        this.seatNumber = "A1";
        this.classType  = "Economy";
        this.price      = 300.0;
    }

    // ── Parameterized Constructor ────────────────────────────────────────────
    public Ticket(String ticketId, Passenger passenger, Flight flight,
                  String seatNumber, String classType) {
        this.ticketId   = ticketId;
        this.passenger  = passenger;
        this.flight     = flight;
        this.seatNumber = seatNumber;
        this.classType  = classType;
        this.price      = calculateTicketPrice();
    }

    // ── Getters & Setters ────────────────────────────────────────────────────
    public String    getTicketId()   { return ticketId; }
    public Passenger getPassenger()  { return passenger; }
    public Flight    getFlight()     { return flight; }
    public String    getSeatNumber() { return seatNumber; }
    public String    getClassType()  { return classType; }
    public double    getPrice()      { return price; }

    public void setTicketId(String ticketId)       { this.ticketId   = ticketId; }
    public void setPassenger(Passenger passenger)  { this.passenger  = passenger; }
    public void setFlight(Flight flight)           { this.flight     = flight; }
    public void setSeatNumber(String seatNumber)   { this.seatNumber = seatNumber; }
    public void setClassType(String classType)     { this.classType  = classType; this.price = calculateTicketPrice(); }

    // ── Calculate price based on class ──────────────────────────────────────
    public double calculateTicketPrice() {
        switch (classType) {
            case "First":    return 1500.0;
            case "Business": return 800.0;
            default:         return 300.0;  // Economy
        }
    }

    // ── Print full ticket ────────────────────────────────────────────────────
    public void generateTicketDetails() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║          TICKET              ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ Ticket ID  : " + ticketId);
        System.out.println("║ Passenger  : " + passenger.getFullName());
        System.out.println("║ Flight     : " + flight.getFlightId());
        System.out.println("║ Route      : " + flight.getDepartureLocation() + " -> " + flight.getDestination());
        System.out.println("║ Seat       : " + seatNumber + " (" + classType + ")");
        System.out.println("║ Price      : $" + price);
        System.out.println("╚══════════════════════════════╝");
    }

    @Override
    public String toString() {
        return "Ticket[" + ticketId + "] Seat: " + seatNumber
                + " | Class: " + classType + " | Price: $" + price;
    }
}
