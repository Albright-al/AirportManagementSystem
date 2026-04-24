package airport;

/**
 * CLASS: Flight (Base Class)
 * Parent of DomesticFlight, InternationalFlight, CargoFlight, CharterFlight, EmergencyFlight.
 * Contains the shared fields and methods all flight types have in common.
 */
public class Flight {

    // ── Private fields ───────────────────────────────────────────────────────
    private String flightId;
    private String airlineName;
    private String departureLocation;
    private String destination;
    private int    departureHour;
    private int    arrivalHour;
    private int    capacity;

    // ── Default Constructor ──────────────────────────────────────────────────
    public Flight() {
        this.flightId           = "F000";
        this.airlineName        = "Unknown Airline";
        this.departureLocation  = "Unknown";
        this.destination        = "Unknown";
        this.departureHour      = 0;
        this.arrivalHour        = 0;
        this.capacity           = 0;
    }

    // ── Parameterized Constructor ────────────────────────────────────────────
    public Flight(String flightId, String airlineName, String departureLocation,
                  String destination, int departureHour, int arrivalHour, int capacity) {
        this.flightId          = flightId;
        this.airlineName       = airlineName;
        this.departureLocation = departureLocation;
        this.destination       = destination;
        this.departureHour     = departureHour;
        this.arrivalHour       = arrivalHour;
        this.capacity          = capacity;
    }

    // ── Getters ──────────────────────────────────────────────────────────────
    public String getFlightId()          { return flightId; }
    public String getAirlineName()       { return airlineName; }
    public String getDepartureLocation() { return departureLocation; }
    public String getDestination()       { return destination; }
    public int    getDepartureHour()     { return departureHour; }
    public int    getArrivalHour()       { return arrivalHour; }
    public int    getCapacity()          { return capacity; }

    // ── Setters ──────────────────────────────────────────────────────────────
    public void setFlightId(String flightId)                 { this.flightId          = flightId; }
    public void setAirlineName(String airlineName)           { this.airlineName       = airlineName; }
    public void setDepartureLocation(String departureLocation){ this.departureLocation= departureLocation; }
    public void setDestination(String destination)           { this.destination       = destination; }
    public void setDepartureHour(int departureHour)          { this.departureHour     = departureHour; }
    public void setArrivalHour(int arrivalHour)              { this.arrivalHour       = arrivalHour; }
    public void setCapacity(int capacity)                    { this.capacity          = capacity; }

    // ── Calculate flight duration in hours ───────────────────────────────────
    public int calculateFlightDuration() {
        return arrivalHour - departureHour;
    }

    @Override
    public String toString() {
        return "Flight[" + flightId + "] " + airlineName
                + " | " + departureLocation + " -> " + destination
                + " | Departs: " + departureHour + ":00"
                + " | Arrives: " + arrivalHour + ":00"
                + " | Duration: " + calculateFlightDuration() + "h"
                + " | Capacity: " + capacity;
    }
}
