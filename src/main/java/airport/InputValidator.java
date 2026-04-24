package airport;

/**
 * CLASS: InputValidator
 * Validates all user input before objects are created.
 * Returns true if valid, false if not — and prints a clear error message.
 */
public class InputValidator {

    // ── Check input is not empty or blank ────────────────────────────────────
    public boolean isNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("  [ERROR] Input cannot be empty. Please try again.");
            return false;
        }
        return true;
    }

    // ── Check a number is positive ───────────────────────────────────────────
    public boolean isPositiveNumber(double value) {
        if (value <= 0) {
            System.out.println("  [ERROR] Value must be greater than zero.");
            return false;
        }
        return true;
    }

    // ── Passport: 2 uppercase letters + 7 digits  e.g. AB1234567 ────────────
    public boolean isValidPassport(String passport) {
        if (passport == null || !passport.matches("[A-Z]{2}[0-9]{7}")) {
            System.out.println("  [ERROR] Invalid passport format. Required: 2 letters + 7 digits (e.g. AB1234567).");
            return false;
        }
        return true;
    }

    // ── Flight ID: 2 uppercase letters + 3 digits  e.g. KQ101 ───────────────
    public boolean isValidFlightId(String flightId) {
        if (flightId == null || !flightId.matches("[A-Z]{2}[0-9]{3}")) {
            System.out.println("  [ERROR] Invalid Flight ID format. Required: 2 letters + 3 digits (e.g. KQ101).");
            return false;
        }
        return true;
    }

    // ── Seat: 1 uppercase letter + 1 or 2 digits  e.g. A1, B12 ─────────────
    public boolean isValidSeat(String seat) {
        if (seat == null || !seat.matches("[A-Z][0-9]{1,2}")) {
            System.out.println("  [ERROR] Invalid seat format. Required: 1 letter + 1-2 digits (e.g. A1, B12).");
            return false;
        }
        return true;
    }

    // ── Phone: digits only, 7 to 15 characters ──────────────────────────────
    public boolean isValidPhone(String phone) {
        if (phone == null || !phone.matches("[0-9]{7,15}")) {
            System.out.println("  [ERROR] Invalid phone number. Must be 7-15 digits only.");
            return false;
        }
        return true;
    }

    // ── Class type must be one of three accepted values ──────────────────────
    public boolean isValidClassType(String classType) {
        if (classType == null ||
           (!classType.equalsIgnoreCase("Economy") &&
            !classType.equalsIgnoreCase("Business") &&
            !classType.equalsIgnoreCase("First"))) {
            System.out.println("  [ERROR] Invalid class. Choose: Economy, Business, or First.");
            return false;
        }
        return true;
    }

    // ── Flight type must be one of five accepted values ──────────────────────
    public boolean isValidFlightType(String type) {
        if (type == null ||
           (!type.equalsIgnoreCase("DOMESTIC") &&
            !type.equalsIgnoreCase("INTERNATIONAL") &&
            !type.equalsIgnoreCase("CARGO") &&
            !type.equalsIgnoreCase("CHARTER") &&
            !type.equalsIgnoreCase("EMERGENCY"))) {
            System.out.println("  [ERROR] Invalid flight type. Choose: DOMESTIC, INTERNATIONAL, CARGO, CHARTER, EMERGENCY.");
            return false;
        }
        return true;
    }
}
