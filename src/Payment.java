import java.math.BigDecimal;

public abstract class Payment {

    // Variables
    private BigDecimal amount;

    // Constructor
    protected Payment(BigDecimal amount) {
        this.amount = amount;
    }

    // Getters and Setters
    public BigDecimal getAmount() {
        return amount;
    }

    // Methods
    public String Describe() {
        return "Amount Paid: $" + amount;
    }

    @Override
    public String toString() {
        return Describe();
    }
}
