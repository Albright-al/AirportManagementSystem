package airport;

// ============================================================
//  CLASS: Staff (Base Class)
//  Parent of Pilot, CabinCrew, GroundStaff, SecurityOfficer, MaintenanceStaff
// ============================================================
public class Staff {

    private String staffId;
    private String name;
    private String role;
    private double salary;

    public Staff() {
        this.staffId = "S000";
        this.name    = "Unknown";
        this.role    = "General";
        this.salary  = 0.0;
    }

    public Staff(String staffId, String name, String role, double salary) {
        this.staffId = staffId;
        this.name    = name;
        this.role    = role;
        this.salary  = salary;
    }

    public String getStaffId() { return staffId; }
    public String getName()    { return name; }
    public String getRole()    { return role; }
    public double getSalary()  { return salary; }

    public void setStaffId(String staffId) { this.staffId = staffId; }
    public void setName(String name)       { this.name    = name; }
    public void setRole(String role)       { this.role    = role; }
    public void setSalary(double salary)   { this.salary  = salary; }

    @Override
    public String toString() {
        return "Staff[" + staffId + "] " + name + " | Role: " + role + " | Salary: $" + salary;
    }
}

// ============================================================
//  SUBCLASS 1: Pilot
//  Unique field: flightHours
// ============================================================
class Pilot extends Staff {

    private int flightHours;

    public Pilot() { super(); this.flightHours = 0; }

    public Pilot(String staffId, String name, double salary, int flightHours) {
        super(staffId, name, "Pilot", salary);
        this.flightHours = flightHours;
    }

    public int  getFlightHours()           { return flightHours; }
    public void setFlightHours(int hours)  { this.flightHours = hours; }

    @Override
    public String toString() { return "[PILOT] " + super.toString() + " | Flight Hours: " + flightHours; }
}

// ============================================================
//  SUBCLASS 2: CabinCrew
//  Unique field: languageSkills
// ============================================================
class CabinCrew extends Staff {

    private String languageSkills;

    public CabinCrew() { super(); this.languageSkills = "English"; }

    public CabinCrew(String staffId, String name, double salary, String languages) {
        super(staffId, name, "Cabin Crew", salary);
        this.languageSkills = languages;
    }

    public String getLanguageSkills()              { return languageSkills; }
    public void   setLanguageSkills(String lang)   { this.languageSkills = lang; }

    @Override
    public String toString() { return "[CABIN CREW] " + super.toString() + " | Languages: " + languageSkills; }
}

// ============================================================
//  SUBCLASS 3: GroundStaff
//  Unique field: department
// ============================================================
class GroundStaff extends Staff {

    private String department;

    public GroundStaff() { super(); this.department = "General"; }

    public GroundStaff(String staffId, String name, double salary, String department) {
        super(staffId, name, "Ground Staff", salary);
        this.department = department;
    }

    public String getDepartment()              { return department; }
    public void   setDepartment(String dept)   { this.department = dept; }

    @Override
    public String toString() { return "[GROUND STAFF] " + super.toString() + " | Department: " + department; }
}

// ============================================================
//  SUBCLASS 4: SecurityOfficer
//  Unique field: securityLevel (1-5)
// ============================================================
class SecurityOfficer extends Staff {

    private int securityLevel;

    public SecurityOfficer() { super(); this.securityLevel = 1; }

    public SecurityOfficer(String staffId, String name, double salary, int level) {
        super(staffId, name, "Security Officer", salary);
        this.securityLevel = level;
    }

    public int  getSecurityLevel()           { return securityLevel; }
    public void setSecurityLevel(int level)  { this.securityLevel = level; }

    @Override
    public String toString() { return "[SECURITY] " + super.toString() + " | Security Level: " + securityLevel; }
}

// ============================================================
//  SUBCLASS 5: MaintenanceStaff
//  Unique field: specialization
// ============================================================
class MaintenanceStaff extends Staff {

    private String specialization;

    public MaintenanceStaff() { super(); this.specialization = "General"; }

    public MaintenanceStaff(String staffId, String name, double salary, String spec) {
        super(staffId, name, "Maintenance", salary);
        this.specialization = spec;
    }

    public String getSpecialization()              { return specialization; }
    public void   setSpecialization(String spec)   { this.specialization = spec; }

    @Override
    public String toString() { return "[MAINTENANCE] " + super.toString() + " | Specialization: " + specialization; }
}
