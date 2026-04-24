package airport;

/**
 * ABSTRACT CLASS: AirportEntity
 * This is the ROOT (top-level) parent of the entire system.
 * It cannot be instantiated directly — you must extend it.
 * All fields are PRIVATE (encapsulation).
 */
public abstract class AirportEntity {

    // ── Private fields (encapsulation) ──────────────────────────────────────
    private String entityId;
    private String name;
    private String status;
    private String createdDate;
    private String lastUpdated;

    // ── Default Constructor ──────────────────────────────────────────────────
    public AirportEntity() {
        this.entityId    = "UNKNOWN";
        this.name        = "UNKNOWN";
        this.status      = "INACTIVE";
        this.createdDate = "2024-01-01";
        this.lastUpdated = "2024-01-01";
    }

    // ── Parameterized Constructor ────────────────────────────────────────────
    public AirportEntity(String entityId, String name, String status,
                         String createdDate, String lastUpdated) {
        this.entityId    = entityId;
        this.name        = name;
        this.status      = status;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
    }

    // ── Getters ──────────────────────────────────────────────────────────────
    public String getEntityId()    { return entityId; }
    public String getName()        { return name; }
    public String getStatus()      { return status; }
    public String getCreatedDate() { return createdDate; }
    public String getLastUpdated() { return lastUpdated; }

    // ── Setters ──────────────────────────────────────────────────────────────
    public void setEntityId(String entityId)       { this.entityId    = entityId; }
    public void setName(String name)               { this.name        = name; }
    public void setStatus(String status)           { this.status      = status; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }
    public void setLastUpdated(String lastUpdated) { this.lastUpdated = lastUpdated; }

    // ── toString override ────────────────────────────────────────────────────
    @Override
    public String toString() {
        return "ID: " + entityId + " | Name: " + name + " | Status: " + status
                + " | Created: " + createdDate;
    }

    // ── Abstract Methods (subclasses MUST implement all 10) ──────────────────
    public abstract void validateEntity();
    public abstract void activateEntity();
    public abstract void deactivateEntity();
    public abstract void updateDetails();
    public abstract void generateReport();
    public abstract void logActivity();
    public abstract void checkStatus();
    public abstract void archiveEntity();
    public abstract void restoreEntity();
    public abstract void displaySummary();
}
