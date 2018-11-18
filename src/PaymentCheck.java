import java.math.BigDecimal;

public class PaymentCheck extends Payment{

    // Variables
    private int checkNumber;

    // Constructor

    public PaymentCheck(BigDecimal amount, int checkNumber) {
        super(amount);
        this.checkNumber = checkNumber;
    }

    // Getters and Setters
    public int getCheckNumber() {
        return checkNumber;
    }

    // Methods
    @Override
    public String Describe() {
        return super.Describe() + " via Check (" + checkNumber + ")";
    }
}
