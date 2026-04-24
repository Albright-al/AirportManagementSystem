package airport;

// ============================================================
//  CLASS: ReportGenerator
//  Generates printed reports. No fields — purely a utility class.
// ============================================================
public class ReportGenerator {

    public void generateDailyFlightsReport(Flight[] flights) {
        System.out.println("\n========== DAILY FLIGHTS REPORT ==========");
        if (flights.length == 0) { System.out.println("No flights today."); return; }
        for (Flight f : flights) {
            System.out.println("  " + f);
        }
        System.out.println("  Total Flights: " + flights.length);
        System.out.println("==========================================");
    }

    public void generatePassengerStats(Passenger[] passengers) {
        System.out.println("\n========== PASSENGER STATISTICS ==========");
        System.out.println("  Total Passengers: " + passengers.length);
        for (Passenger p : passengers) {
            System.out.println("  " + p.getFullName() + " | " + p.getNationality());
        }
        System.out.println("==========================================");
    }

    public void generateRevenueReport(Ticket[] tickets) {
        System.out.println("\n========== REVENUE REPORT ==========");
        double total = 0;
        for (Ticket t : tickets) {
            System.out.println("  Ticket " + t.getTicketId() + " → $" + t.getPrice());
            total += t.getPrice();
        }
        System.out.println("  TOTAL REVENUE: $" + total);
        System.out.println("=====================================");
    }

    public void generateDelaysReport(Flight[] delayedFlights) {
        System.out.println("\n========== DELAYED FLIGHTS REPORT ==========");
        if (delayedFlights.length == 0) { System.out.println("  No delays."); return; }
        for (Flight f : delayedFlights) {
            System.out.println("  DELAYED: " + f.getFlightId() + " | " + f.getAirlineName());
        }
        System.out.println("  Total Delays: " + delayedFlights.length);
        System.out.println("=============================================");
    }
}
