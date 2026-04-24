package airport;

/**
 * CLASS: BoardingPass
 * Generated after a ticket is purchased. Links ticket to a gate and boarding time.
 */
public class BoardingPass {

    private String ticketBoardingPassId;
    private Ticket ticket;
    private String gateNumber;
    private String boardingTime;

    // ── Default Constructor ──────────────────────────────────────────────────
    public BoardingPass() {
        this.ticketBoardingPassId = "BP000";
        this.gateNumber           = "G1";
        this.boardingTime         = "00:00";
    }

    // ── Parameterized Constructor ────────────────────────────────────────────
    public BoardingPass(String boardingPassId, Ticket ticket,
                        String gateNumber, String boardingTime) {
        this.ticketBoardingPassId = boardingPassId;
        this.ticket               = ticket;
        this.gateNumber           = gateNumber;
        this.boardingTime         = boardingTime;
    }

    // ── Getters & Setters ────────────────────────────────────────────────────
    public String getBoardingPassId() { return ticketBoardingPassId; }
    public Ticket getTicket()         { return ticket; }
    public String getGateNumber()     { return gateNumber; }
    public String getBoardingTime()   { return boardingTime; }

    public void setBoardingPassId(String id)     { this.ticketBoardingPassId = id; }
    public void setTicket(Ticket ticket)         { this.ticket               = ticket; }
    public void setGateNumber(String gateNumber) { this.gateNumber           = gateNumber; }
    public void setBoardingTime(String time)     { this.boardingTime         = time; }

    public void printBoardingPass() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       BOARDING PASS          ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ Pass ID    : " + ticketBoardingPassId);
        System.out.println("║ Passenger  : " + ticket.getPassenger().getFullName());
        System.out.println("║ Flight     : " + ticket.getFlight().getFlightId());
        System.out.println("║ Seat       : " + ticket.getSeatNumber());
        System.out.println("║ Gate       : " + gateNumber);
        System.out.println("║ Board Time : " + boardingTime);
        System.out.println("╚══════════════════════════════╝");
    }

    @Override
    public String toString() {
        return "BoardingPass[" + ticketBoardingPassId + "] Gate: " + gateNumber
                + " | Board at: " + boardingTime
                + " | Passenger: " + ticket.getPassenger().getFullName();
    }
}
