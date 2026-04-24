package airport;

/**
 * CLASS: FlightFactory
 *
 * DESIGN PATTERN: Factory Pattern
 * Instead of the main program calling "new DomesticFlight(...)" directly,
 * it asks the factory: "Give me a flight of type DOMESTIC."
 *
 * POLYMORPHISM in action:
 * The return type is always Flight (the parent class),
 * but the actual object created is a specific subclass.
 * This means you can treat all flights the same way in your code,
 * even though they behave differently at runtime.
 */
public class FlightFactory {

    /**
     * Creates and returns the correct Flight subclass based on the type string.
     *
     * @param type              "DOMESTIC", "INTERNATIONAL", "CARGO", "CHARTER", or "EMERGENCY"
     * @param flightId          e.g. "KQ101"
     * @param airline           Airline name
     * @param from              Departure city
     * @param to                Destination city
     * @param departureHour     Hour of departure (0-23)
     * @param arrivalHour       Hour of arrival (0-23)
     * @param capacity          Number of seats
     * @return                  A Flight object (could be any subclass)
     */
    public static Flight createFlight(String type, String flightId, String airline,
                                      String from, String to,
                                      int departureHour, int arrivalHour, int capacity) {
        switch (type.toUpperCase()) {

            case "DOMESTIC":
                // regionCode is defaulted to "EA" (East Africa) for demo
                return new DomesticFlight(flightId, airline, from, to,
                                          departureHour, arrivalHour, capacity, "EA");

            case "INTERNATIONAL":
                // passport is always required for international
                return new InternationalFlight(flightId, airline, from, to,
                                               departureHour, arrivalHour, capacity, true);

            case "CARGO":
                // default cargo weight limit: 5000 kg
                return new CargoFlight(flightId, airline, from, to,
                                       departureHour, arrivalHour, capacity, 5000.0);

            case "CHARTER":
                // default private client name
                return new CharterFlight(flightId, airline, from, to,
                                         departureHour, arrivalHour, capacity, "VIP Client");

            case "EMERGENCY":
                // highest emergency level: 5
                return new EmergencyFlight(flightId, airline, from, to,
                                           departureHour, arrivalHour, capacity, 5);

            default:
                System.out.println("  [FACTORY] Unknown type '" + type + "'. Creating base Flight.");
                return new Flight(flightId, airline, from, to,
                                  departureHour, arrivalHour, capacity);
        }
    }
}
