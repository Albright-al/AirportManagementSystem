package airport;

import java.util.Scanner;

/**
 * CLASS: AirportSystem  (MAIN CLASS — run this to start the program)
 *
 * This is the entry point of the entire Airport Management System.
 * It ties together every class we built:
 *   - Collects and validates user input
 *   - Uses FlightFactory to create flights (polymorphism)
 *   - Creates Passenger, Ticket, Reservation, SecurityCheck, Payment, BoardingPass
 *   - Sends a Notification
 *   - Generates Reports
 */
public class AirportSystem {

    public static void main(String[] args) {

        Scanner scanner       = new Scanner(System.in);
        InputValidator validator = new InputValidator();

        printBanner();

        // ════════════════════════════════════════════════════════
        //  STEP 1: Collect Passenger Details (with validation)
        // ════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│     STEP 1: PASSENGER DETAILS   │");
        System.out.println("└─────────────────────────────────┘");

        // Full name — keep asking until non-empty
        String fullName = "";
        while (!validator.isNotEmpty(fullName)) {
            System.out.print("  Full Name       : ");
            fullName = scanner.nextLine().trim();
        }

        // Passport — must match AB1234567 format
        String passport = "";
        while (!validator.isValidPassport(passport)) {
            System.out.print("  Passport No     : ");
            passport = scanner.nextLine().trim().toUpperCase();
        }

        // Nationality
        String nationality = "";
        while (!validator.isNotEmpty(nationality)) {
            System.out.print("  Nationality     : ");
            nationality = scanner.nextLine().trim();
        }

        // Phone — digits only, 7-15 chars
        String phone = "";
        while (!validator.isValidPhone(phone)) {
            System.out.print("  Phone Number    : ");
            phone = scanner.nextLine().trim();
        }

        // Create the Passenger object
        Passenger passenger = new Passenger("P001", fullName, passport, nationality, phone);
        System.out.println("\n  [OK] Passenger created: " + passenger);

        // ════════════════════════════════════════════════════════
        //  STEP 2: Select Flight Type
        // ════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│     STEP 2: FLIGHT SELECTION    │");
        System.out.println("└─────────────────────────────────┘");
        System.out.println("  Available types: DOMESTIC | INTERNATIONAL | CARGO | CHARTER | EMERGENCY");

        String flightType = "";
        while (!validator.isValidFlightType(flightType)) {
            System.out.print("  Flight Type     : ");
            flightType = scanner.nextLine().trim().toUpperCase();
        }

        // Flight ID — must match KQ101 format
        String flightId = "";
        while (!validator.isValidFlightId(flightId)) {
            System.out.print("  Flight ID       : ");
            flightId = scanner.nextLine().trim().toUpperCase();
        }

        // Use FlightFactory to create the correct subclass — POLYMORPHISM
        Flight flight = FlightFactory.createFlight(
                flightType, flightId, "Kenya Airways",
                "Nairobi", "Dubai", 8, 16, 200
        );
        System.out.println("\n  [OK] Flight created: " + flight);

        // ════════════════════════════════════════════════════════
        //  STEP 3: Seat & Class Selection
        // ════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│  STEP 3: SEAT & CLASS SELECTION │");
        System.out.println("└─────────────────────────────────┘");

        String seat = "";
        while (!validator.isValidSeat(seat)) {
            System.out.print("  Seat Number     : ");
            seat = scanner.nextLine().trim().toUpperCase();
        }

        String classType = "";
        System.out.println("  Class options   : Economy | Business | First");
        while (!validator.isValidClassType(classType)) {
            System.out.print("  Class Type      : ");
            classType = scanner.nextLine().trim();
            // Fix capitalisation — accept "economy", "ECONOMY", etc.
            if (classType.equalsIgnoreCase("economy"))  classType = "Economy";
            if (classType.equalsIgnoreCase("business")) classType = "Business";
            if (classType.equalsIgnoreCase("first"))    classType = "First";
        }

        // ════════════════════════════════════════════════════════
        //  STEP 4: Create Ticket
        // ════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│       STEP 4: YOUR TICKET       │");
        System.out.println("└─────────────────────────────────┘");

        Ticket ticket = new Ticket("T001", passenger, flight, seat, classType);
        ticket.generateTicketDetails();

        // ════════════════════════════════════════════════════════
        //  STEP 5: Create and Confirm Reservation
        // ════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│       STEP 5: RESERVATION       │");
        System.out.println("└─────────────────────────────────┘");

        Reservation reservation = new Reservation("R001", passenger, flight, "2024-12-01");
        reservation.confirmReservation();
        System.out.println("  " + reservation);

        // ════════════════════════════════════════════════════════
        //  STEP 6: Security Check
        // ════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│      STEP 6: SECURITY CHECK     │");
        System.out.println("└─────────────────────────────────┘");

        SecurityCheck securityCheck = new SecurityCheck("SC001", passenger);
        securityCheck.conductCheck();
        System.out.println("  " + securityCheck);

        // ════════════════════════════════════════════════════════
        //  STEP 7: Payment
        // ════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│       STEP 7: PAYMENT           │");
        System.out.println("└─────────────────────────────────┘");
        System.out.println("  Payment options : CASH | CARD | ONLINE");

        String paymentMethod = "";
        while (!validator.isNotEmpty(paymentMethod) ||
               (!paymentMethod.equalsIgnoreCase("CASH") &&
                !paymentMethod.equalsIgnoreCase("CARD") &&
                !paymentMethod.equalsIgnoreCase("ONLINE"))) {
            System.out.print("  Payment Method  : ");
            paymentMethod = scanner.nextLine().trim().toUpperCase();
            if (!paymentMethod.equals("CASH") &&
                !paymentMethod.equals("CARD") &&
                !paymentMethod.equals("ONLINE")) {
                System.out.println("  [ERROR] Choose CASH, CARD, or ONLINE.");
            }
        }

        Payment payment = new Payment("PAY001", ticket.getPrice(), paymentMethod);
        payment.processPayment();
        payment.printReceipt();

        // ════════════════════════════════════════════════════════
        //  STEP 8: Baggage Check-in
        // ════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│    STEP 8: BAGGAGE CHECK-IN     │");
        System.out.println("└─────────────────────────────────┘");

        Baggage baggage = new Baggage("BAG001", 23.5, passenger, "CHECKED");
        System.out.println("  " + baggage);

        // ════════════════════════════════════════════════════════
        //  STEP 9: Assign Gate & Generate Boarding Pass
        // ════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│     STEP 9: BOARDING PASS       │");
        System.out.println("└─────────────────────────────────┘");

        Terminal terminal    = new Terminal("T1", "Terminal One", 500);
        Gate     gate        = new Gate("G7", terminal, "BOARDING");
        Schedule schedule    = new Schedule("SCH001", flight, gate, flight.getDepartureHour());
        System.out.println("  " + schedule);

        BoardingPass boardingPass = new BoardingPass("BP001", ticket, gate.getGateId(), "07:30");
        boardingPass.printBoardingPass();

        // ════════════════════════════════════════════════════════
        //  STEP 10: Send Notification
        // ════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│     STEP 10: NOTIFICATION       │");
        System.out.println("└─────────────────────────────────┘");

        Notification notification = new Notification(
                "N001",
                "Your flight " + flightId + " is confirmed. Gate: " + gate.getGateId() + ". Board by 07:30.",
                passenger.getFullName(),
                "2024-12-01"
        );
        notification.sendNotification();

        // ════════════════════════════════════════════════════════
        //  STEP 11: Generate Reports
        // ════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│      STEP 11: SYSTEM REPORTS    │");
        System.out.println("└─────────────────────────────────┘");

        ReportGenerator reporter = new ReportGenerator();

        Flight[]    allFlights    = { flight };
        Passenger[] allPassengers = { passenger };
        Ticket[]    allTickets    = { ticket };
        Flight[]    delayedFlights = {};                  // no delays in this demo

        reporter.generateDailyFlightsReport(allFlights);
        reporter.generatePassengerStats(allPassengers);
        reporter.generateRevenueReport(allTickets);
        reporter.generateDelaysReport(delayedFlights);

        // ════════════════════════════════════════════════════════
        //  STEP 12: Show Staff & Airport Info (demonstrating those classes)
        // ════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│   STEP 12: STAFF & AIRPORT INFO │");
        System.out.println("└─────────────────────────────────┘");

        Airport airport = new Airport("JKIA", "Jomo Kenyatta International Airport", "Nairobi, Kenya", 4);
        System.out.println("  " + airport);
        System.out.println("  " + terminal);
        System.out.println("  " + gate);

        Pilot          pilot    = new Pilot("ST001", "Capt. James Mwangi", 85000.0, 12000);
        CabinCrew      crew     = new CabinCrew("ST002", "Amina Hassan", 45000.0, "English, Swahili, Arabic");
        GroundStaff    ground   = new GroundStaff("ST003", "Peter Otieno", 38000.0, "Baggage Handling");
        SecurityOfficer sec     = new SecurityOfficer("ST004", "Grace Wambui", 42000.0, 4);
        MaintenanceStaff maint  = new MaintenanceStaff("ST005", "David Kamau", 55000.0, "Engine Systems");

        System.out.println("\n  --- Assigned Staff ---");
        System.out.println("  " + pilot);
        System.out.println("  " + crew);
        System.out.println("  " + ground);
        System.out.println("  " + sec);
        System.out.println("  " + maint);

        // Demonstrate AirportManager
        System.out.println("\n  --- Airport Manager ---");
        AirportManager manager = new AirportManager(
                "MGR001", "Airport Manager", "ACTIVE",
                "2024-01-01", "2024-12-01",
                "JKIA", 1, "Sarah Njoroge"
        );
        manager.displaySummary();
        manager.trackStatus();
        manager.updateLocation("Terminal 1 Control Room");

        // ════════════════════════════════════════════════════════
        //  DONE
        // ════════════════════════════════════════════════════════
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║   AIRPORT SYSTEM — PROCESS COMPLETE  ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("  Safe travels, " + passenger.getFullName() + "!");

        scanner.close();
    }

    // ── Helper: Print startup banner ─────────────────────────────────────────
    private static void printBanner() {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║    AIRPORT MANAGEMENT SYSTEM v1.0        ║");
        System.out.println("║    OOP Java Assignment — Group D         ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }
}
