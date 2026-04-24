package airport;

/**
 * CLASS: Passenger
 * Stores all details about a single passenger.
 * Used by Ticket, Reservation, Baggage, SecurityCheck.
 */
public class Passenger {

    private String passengerId;
    private String fullName;
    private String passportNumber;
    private String nationality;
    private String phoneNumber;

    // ── Default Constructor ──────────────────────────────────────────────────
    public Passenger() {
        this.passengerId    = "P000";
        this.fullName       = "Unknown";
        this.passportNumber = "AB0000000";
        this.nationality    = "Unknown";
        this.phoneNumber    = "0000000000";
    }

    // ── Parameterized Constructor ────────────────────────────────────────────
    public Passenger(String passengerId, String fullName, String passportNumber,
                     String nationality, String phoneNumber) {
        this.passengerId    = passengerId;
        this.fullName       = fullName;
        this.passportNumber = passportNumber;
        this.nationality    = nationality;
        this.phoneNumber    = phoneNumber;
    }

    // ── Getters ──────────────────────────────────────────────────────────────
    public String getPassengerId()    { return passengerId; }
    public String getFullName()       { return fullName; }
    public String getPassportNumber() { return passportNumber; }
    public String getNationality()    { return nationality; }
    public String getPhoneNumber()    { return phoneNumber; }

    // ── Setters ──────────────────────────────────────────────────────────────
    public void setPassengerId(String passengerId)       { this.passengerId    = passengerId; }
    public void setFullName(String fullName)             { this.fullName       = fullName; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
    public void setNationality(String nationality)       { this.nationality    = nationality; }
    public void setPhoneNumber(String phoneNumber)       { this.phoneNumber    = phoneNumber; }

    @Override
    public String toString() {
        return "Passenger[" + passengerId + "] " + fullName
                + " | Passport: " + passportNumber
                + " | Nationality: " + nationality
                + " | Phone: " + phoneNumber;
    }
}
