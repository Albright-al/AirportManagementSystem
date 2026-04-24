package airport;

// ============================================================
//  CLASS: Baggage
// ============================================================
public class Baggage {

    private String    baggageId;
    private double    weight;
    private Passenger owner;
    private String    status;   // UNCHECKED | CHECKED | LOADED | LOST

    public Baggage() {
        this.baggageId = "B000";
        this.weight    = 0.0;
        this.status    = "UNCHECKED";
    }

    public Baggage(String baggageId, double weight, Passenger owner, String status) {
        this.baggageId = baggageId;
        this.weight    = weight;
        this.owner     = owner;
        this.status    = status;
    }

    public String    getBaggageId() { return baggageId; }
    public double    getWeight()    { return weight; }
    public Passenger getOwner()     { return owner; }
    public String    getStatus()    { return status; }

    public void setBaggageId(String id)       { this.baggageId = id; }
    public void setWeight(double weight)      { this.weight    = weight; }
    public void setOwner(Passenger owner)     { this.owner     = owner; }
    public void setStatus(String status)      { this.status    = status; }

    @Override
    public String toString() {
        return "Baggage[" + baggageId + "] Owner: " + owner.getFullName()
                + " | Weight: " + weight + "kg | Status: " + status;
    }
}

// ============================================================
//  CLASS: SecurityCheck
// ============================================================
class SecurityCheck {

    private String    checkId;
    private Passenger passenger;
    private String    status;    // PENDING | CLEARED | FLAGGED
    private String    remarks;

    public SecurityCheck() {
        this.checkId  = "SC000";
        this.status   = "PENDING";
        this.remarks  = "None";
    }

    public SecurityCheck(String checkId, Passenger passenger) {
        this.checkId   = checkId;
        this.passenger = passenger;
        this.status    = "PENDING";
        this.remarks   = "None";
    }

    public String    getCheckId()    { return checkId; }
    public Passenger getPassenger()  { return passenger; }
    public String    getStatus()     { return status; }
    public String    getRemarks()    { return remarks; }

    public void setCheckId(String checkId)    { this.checkId  = checkId; }
    public void setPassenger(Passenger p)     { this.passenger = p; }
    public void setStatus(String status)      { this.status   = status; }
    public void setRemarks(String remarks)    { this.remarks  = remarks; }

    // Passport starting with a letter A-M passes; others flagged (simple demo rule)
    public void conductCheck() {
        char firstChar = passenger.getPassportNumber().charAt(0);
        if (firstChar >= 'A' && firstChar <= 'M') {
            this.status  = "CLEARED";
            this.remarks = "All security checks passed.";
        } else {
            this.status  = "FLAGGED";
            this.remarks = "Requires additional manual screening.";
        }
        System.out.println("[SECURITY] " + passenger.getFullName() + " → " + status);
    }

    @Override
    public String toString() {
        return "SecurityCheck[" + checkId + "] " + passenger.getFullName()
                + " | Status: " + status + " | Remarks: " + remarks;
    }
}

// ============================================================
//  CLASS: Payment
// ============================================================
class Payment {

    private String paymentId;
    private double amount;
    private String paymentMethod;   // CASH | CARD | ONLINE
    private String paymentStatus;   // PENDING | COMPLETED | FAILED

    public Payment() {
        this.paymentId     = "PAY000";
        this.amount        = 0.0;
        this.paymentMethod = "CASH";
        this.paymentStatus = "PENDING";
    }

    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId     = paymentId;
        this.amount        = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = "PENDING";
    }

    public String getPaymentId()     { return paymentId; }
    public double getAmount()        { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }

    public void setPaymentId(String id)          { this.paymentId     = id; }
    public void setAmount(double amount)         { this.amount        = amount; }
    public void setPaymentMethod(String method)  { this.paymentMethod = method; }

    public void processPayment() {
        this.paymentStatus = "COMPLETED";
        System.out.println("[PAYMENT] $" + amount + " via " + paymentMethod + " — COMPLETED.");
    }

    public void printReceipt() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║         RECEIPT              ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ Payment ID : " + paymentId);
        System.out.println("║ Amount     : $" + amount);
        System.out.println("║ Method     : " + paymentMethod);
        System.out.println("║ Status     : " + paymentStatus);
        System.out.println("╚══════════════════════════════╝");
    }

    @Override
    public String toString() {
        return "Payment[" + paymentId + "] $" + amount
                + " | Method: " + paymentMethod + " | Status: " + paymentStatus;
    }
}

// ============================================================
//  CLASS: Schedule
// ============================================================
class Schedule {

    private String scheduleId;
    private Flight flight;
    private Gate   gate;
    private int    departureHour;

    public Schedule() {
        this.scheduleId   = "SCH000";
        this.departureHour = 0;
    }

    public Schedule(String scheduleId, Flight flight, Gate gate, int departureHour) {
        this.scheduleId    = scheduleId;
        this.flight        = flight;
        this.gate          = gate;
        this.departureHour = departureHour;
    }

    public String getScheduleId()   { return scheduleId; }
    public Flight getFlight()       { return flight; }
    public Gate   getGate()         { return gate; }
    public int    getDepartureHour(){ return departureHour; }

    public void setScheduleId(String id)       { this.scheduleId    = id; }
    public void setFlight(Flight flight)       { this.flight        = flight; }
    public void setGate(Gate gate)             { this.gate          = gate; }
    public void setDepartureHour(int hour)     { this.departureHour = hour; }

    @Override
    public String toString() {
        return "Schedule[" + scheduleId + "] Flight: " + flight.getFlightId()
                + " | Gate: " + gate.getGateId()
                + " | Departs: " + departureHour + ":00";
    }
}

// ============================================================
//  CLASS: Notification
// ============================================================
class Notification {

    private String notificationId;
    private String message;
    private String recipient;
    private String date;

    public Notification() {
        this.notificationId = "N000";
        this.message        = "";
        this.recipient      = "";
        this.date           = "2024-01-01";
    }

    public Notification(String notificationId, String message, String recipient, String date) {
        this.notificationId = notificationId;
        this.message        = message;
        this.recipient      = recipient;
        this.date           = date;
    }

    public String getNotificationId() { return notificationId; }
    public String getMessage()        { return message; }
    public String getRecipient()      { return recipient; }
    public String getDate()           { return date; }

    public void setNotificationId(String id)  { this.notificationId = id; }
    public void setMessage(String message)    { this.message        = message; }
    public void setRecipient(String rec)      { this.recipient      = rec; }
    public void setDate(String date)          { this.date           = date; }

    public void sendNotification() {
        System.out.println("[NOTIFICATION] To: " + recipient + " | " + message + " (" + date + ")");
    }

    @Override
    public String toString() {
        return "Notification[" + notificationId + "] To: " + recipient + " | " + message;
    }
}
