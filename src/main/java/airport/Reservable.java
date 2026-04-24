package airport;

/**
 * INTERFACE: Reservable
 * Any class that implements this MUST provide these 3 methods.
 */
public interface Reservable {
    void createReservation();
    void cancelReservation();
    void modifyReservation();
}
