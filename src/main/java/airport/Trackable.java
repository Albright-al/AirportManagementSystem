package airport;

/**
 * INTERFACE: Trackable
 * Any class that implements this MUST provide these 3 methods.
 */
public interface Trackable {
    void trackStatus();
    void updateLocation(String location);
    String getCurrentLocation();
}
