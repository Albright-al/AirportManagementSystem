package airport;

/**
 * INTERFACE: Payable
 * Any class that implements this MUST provide these 3 methods.
 */
public interface Payable {
    void processPayment();
    double calculateAmount();
    void generateReceipt();
}
