package airport;

// ============================================================
//  CLASS: Airport
// ============================================================
public class Airport {

    private String airportId;
    private String name;
    private String location;
    private int    numberOfTerminals;

    public Airport() {
        this.airportId         = "AP0";
        this.name              = "Unknown Airport";
        this.location          = "Unknown";
        this.numberOfTerminals = 0;
    }

    public Airport(String airportId, String name, String location, int numberOfTerminals) {
        this.airportId         = airportId;
        this.name              = name;
        this.location          = location;
        this.numberOfTerminals = numberOfTerminals;
    }

    public String getAirportId()        { return airportId; }
    public String getName()             { return name; }
    public String getLocation()         { return location; }
    public int    getNumberOfTerminals(){ return numberOfTerminals; }

    public void setAirportId(String id)             { this.airportId         = id; }
    public void setName(String name)                { this.name              = name; }
    public void setLocation(String location)        { this.location          = location; }
    public void setNumberOfTerminals(int n)         { this.numberOfTerminals = n; }

    @Override
    public String toString() {
        return "Airport[" + airportId + "] " + name + " @ " + location
                + " | Terminals: " + numberOfTerminals;
    }
}

// ============================================================
//  CLASS: Terminal
// ============================================================
class Terminal {

    private String terminalId;
    private String name;
    private int    capacity;

    public Terminal() {
        this.terminalId = "T0";
        this.name       = "Unknown";
        this.capacity   = 0;
    }

    public Terminal(String terminalId, String name, int capacity) {
        this.terminalId = terminalId;
        this.name       = name;
        this.capacity   = capacity;
    }

    public String getTerminalId() { return terminalId; }
    public String getName()       { return name; }
    public int    getCapacity()   { return capacity; }

    public void setTerminalId(String id)    { this.terminalId = id; }
    public void setName(String name)        { this.name       = name; }
    public void setCapacity(int capacity)   { this.capacity   = capacity; }

    @Override
    public String toString() {
        return "Terminal[" + terminalId + "] " + name + " | Capacity: " + capacity;
    }
}

// ============================================================
//  CLASS: Gate
// ============================================================
class Gate {

    private String   gateId;
    private Terminal terminal;
    private String   status;    // OPEN | CLOSED | BOARDING

    public Gate() {
        this.gateId  = "G0";
        this.status  = "CLOSED";
    }

    public Gate(String gateId, Terminal terminal, String status) {
        this.gateId   = gateId;
        this.terminal = terminal;
        this.status   = status;
    }

    public String   getGateId()   { return gateId; }
    public Terminal getTerminal() { return terminal; }
    public String   getStatus()   { return status; }

    public void setGateId(String gateId)     { this.gateId   = gateId; }
    public void setTerminal(Terminal t)      { this.terminal = t; }
    public void setStatus(String status)     { this.status   = status; }

    @Override
    public String toString() {
        return "Gate[" + gateId + "] Status: " + status
                + " | Terminal: " + (terminal != null ? terminal.getName() : "N/A");
    }
}
