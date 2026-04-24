package airport;

// ============================================================
//  SUBCLASS 1: DomesticFlight
//  Unique field: regionCode (e.g. "EA" for East Africa)
// ============================================================
class DomesticFlight extends Flight {

    private String regionCode;

    public DomesticFlight() {
        super();
        this.regionCode = "N/A";
    }

    public DomesticFlight(String flightId, String airline, String from,
                          String to, int dep, int arr, int cap, String regionCode) {
        super(flightId, airline, from, to, dep, arr, cap);
        this.regionCode = regionCode;
    }

    public String getRegionCode()              { return regionCode; }
    public void   setRegionCode(String code)   { this.regionCode = code; }

    @Override
    public int calculateFlightDuration() {
        System.out.println("  [Domestic] Short-haul duration calculation.");
        return super.calculateFlightDuration();
    }

    @Override
    public String toString() {
        return "[DOMESTIC | Region: " + regionCode + "] " + super.toString();
    }
}

// ============================================================
//  SUBCLASS 2: InternationalFlight
//  Unique field: passportRequired
// ============================================================
class InternationalFlight extends Flight {

    private boolean passportRequired;

    public InternationalFlight() {
        super();
        this.passportRequired = true;
    }

    public InternationalFlight(String flightId, String airline, String from,
                               String to, int dep, int arr, int cap, boolean passportRequired) {
        super(flightId, airline, from, to, dep, arr, cap);
        this.passportRequired = passportRequired;
    }

    public boolean isPassportRequired()              { return passportRequired; }
    public void    setPassportRequired(boolean req)  { this.passportRequired = req; }

    @Override
    public int calculateFlightDuration() {
        System.out.println("  [International] Long-haul duration calculation.");
        return super.calculateFlightDuration();
    }

    @Override
    public String toString() {
        return "[INTERNATIONAL | Passport Required: " + passportRequired + "] " + super.toString();
    }
}

// ============================================================
//  SUBCLASS 3: CargoFlight
//  Unique field: cargoWeightLimit (kg)
// ============================================================
class CargoFlight extends Flight {

    private double cargoWeightLimit;

    public CargoFlight() {
        super();
        this.cargoWeightLimit = 0.0;
    }

    public CargoFlight(String flightId, String airline, String from,
                       String to, int dep, int arr, int cap, double cargoWeightLimit) {
        super(flightId, airline, from, to, dep, arr, cap);
        this.cargoWeightLimit = cargoWeightLimit;
    }

    public double getCargoWeightLimit()               { return cargoWeightLimit; }
    public void   setCargoWeightLimit(double limit)   { this.cargoWeightLimit = limit; }

    @Override
    public int calculateFlightDuration() {
        System.out.println("  [Cargo] Weight-load duration check.");
        return super.calculateFlightDuration();
    }

    @Override
    public String toString() {
        return "[CARGO | Max Weight: " + cargoWeightLimit + "kg] " + super.toString();
    }
}

// ============================================================
//  SUBCLASS 4: CharterFlight
//  Unique field: privateClientName
// ============================================================
class CharterFlight extends Flight {

    private String privateClientName;

    public CharterFlight() {
        super();
        this.privateClientName = "Unknown Client";
    }

    public CharterFlight(String flightId, String airline, String from,
                         String to, int dep, int arr, int cap, String clientName) {
        super(flightId, airline, from, to, dep, arr, cap);
        this.privateClientName = clientName;
    }

    public String getPrivateClientName()              { return privateClientName; }
    public void   setPrivateClientName(String name)   { this.privateClientName = name; }

    @Override
    public int calculateFlightDuration() {
        System.out.println("  [Charter] Private schedule calculation.");
        return super.calculateFlightDuration();
    }

    @Override
    public String toString() {
        return "[CHARTER | Client: " + privateClientName + "] " + super.toString();
    }
}

// ============================================================
//  SUBCLASS 5: EmergencyFlight
//  Unique field: emergencyLevel (1=low, 5=critical)
// ============================================================
class EmergencyFlight extends Flight {

    private int emergencyLevel;

    public EmergencyFlight() {
        super();
        this.emergencyLevel = 1;
    }

    public EmergencyFlight(String flightId, String airline, String from,
                           String to, int dep, int arr, int cap, int emergencyLevel) {
        super(flightId, airline, from, to, dep, arr, cap);
        this.emergencyLevel = emergencyLevel;
    }

    public int  getEmergencyLevel()              { return emergencyLevel; }
    public void setEmergencyLevel(int level)     { this.emergencyLevel = level; }

    @Override
    public int calculateFlightDuration() {
        System.out.println("  [EMERGENCY] Fastest route — priority calculation.");
        return super.calculateFlightDuration();
    }

    @Override
    public String toString() {
        return "[EMERGENCY | Level: " + emergencyLevel + "/5] " + super.toString();
    }
}
