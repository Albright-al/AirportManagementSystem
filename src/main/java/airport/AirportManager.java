package airport;

/**
 * CLASS: AirportManager
 * - EXTENDS AirportEntity       → inherits all entity fields & must implement 10 abstract methods
 * - IMPLEMENTS Reservable       → must implement createReservation, cancelReservation, modifyReservation
 * - IMPLEMENTS Payable          → must implement processPayment, calculateAmount, generateReceipt
 * - IMPLEMENTS Trackable        → must implement trackStatus, updateLocation, getCurrentLocation
 */
public class AirportManager extends AirportEntity
        implements Reservable, Payable, Trackable {

    // ── Additional attributes ────────────────────────────────────────────────
    private String airportName;
    private int    terminalNumber;
    private String managerName;
    private String currentLocation;

    // ── Default Constructor ──────────────────────────────────────────────────
    public AirportManager() {
        super();
        this.airportName     = "Unknown Airport";
        this.terminalNumber  = 0;
        this.managerName     = "Unknown Manager";
        this.currentLocation = "Office";
    }

    // ── Parameterized Constructor ────────────────────────────────────────────
    public AirportManager(String entityId, String name, String status,
                          String createdDate, String lastUpdated,
                          String airportName, int terminalNumber, String managerName) {
        super(entityId, name, status, createdDate, lastUpdated);
        this.airportName     = airportName;
        this.terminalNumber  = terminalNumber;
        this.managerName     = managerName;
        this.currentLocation = "Main Terminal";
    }

    // ── Getters & Setters ────────────────────────────────────────────────────
    public String getAirportName()   { return airportName; }
    public int    getTerminalNumber(){ return terminalNumber; }
    public String getManagerName()   { return managerName; }

    public void setAirportName(String airportName)      { this.airportName    = airportName; }
    public void setTerminalNumber(int terminalNumber)   { this.terminalNumber = terminalNumber; }
    public void setManagerName(String managerName)      { this.managerName    = managerName; }

    // ── Implementing 10 abstract methods from AirportEntity ─────────────────
    @Override public void validateEntity()   { System.out.println("[VALIDATE] Manager: " + managerName + " is valid."); }
    @Override public void activateEntity()   { setStatus("ACTIVE");   System.out.println("[ACTIVATE] " + managerName + " is now ACTIVE."); }
    @Override public void deactivateEntity() { setStatus("INACTIVE"); System.out.println("[DEACTIVATE] " + managerName + " is INACTIVE."); }
    @Override public void updateDetails()    { System.out.println("[UPDATE] Manager details updated."); }
    @Override public void generateReport()   { System.out.println("[REPORT] Generating report for: " + airportName); }
    @Override public void logActivity()      { System.out.println("[LOG] Activity logged for: " + managerName); }
    @Override public void checkStatus()      { System.out.println("[STATUS] Current status: " + getStatus()); }
    @Override public void archiveEntity()    { System.out.println("[ARCHIVE] " + managerName + " has been archived."); }
    @Override public void restoreEntity()    { System.out.println("[RESTORE] " + managerName + " has been restored."); }
    @Override public void displaySummary()   {
        System.out.println("=== MANAGER SUMMARY ===");
        System.out.println("Name     : " + managerName);
        System.out.println("Airport  : " + airportName);
        System.out.println("Terminal : " + terminalNumber);
        System.out.println("Status   : " + getStatus());
    }

    // ── Implementing Reservable ──────────────────────────────────────────────
    @Override public void createReservation() { System.out.println("[RESERVATION] Created by " + managerName); }
    @Override public void cancelReservation() { System.out.println("[RESERVATION] Cancelled by " + managerName); }
    @Override public void modifyReservation() { System.out.println("[RESERVATION] Modified by " + managerName); }

    // ── Implementing Payable ─────────────────────────────────────────────────
    @Override public void   processPayment()  { System.out.println("[PAYMENT] Processed."); }
    @Override public double calculateAmount() { return 0.0; }
    @Override public void   generateReceipt() { System.out.println("[RECEIPT] Generated."); }

    // ── Implementing Trackable ───────────────────────────────────────────────
    @Override public void   trackStatus()              { System.out.println("[TRACK] Status: " + getStatus()); }
    @Override public void   updateLocation(String loc) { this.currentLocation = loc; System.out.println("[LOCATION] Updated to: " + loc); }
    @Override public String getCurrentLocation()       { return currentLocation; }

    @Override
    public String toString() {
        return super.toString() + " | Manager: " + managerName + " | Airport: " + airportName;
    }
}
