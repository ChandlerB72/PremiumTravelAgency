import java.math.BigDecimal;

public abstract class Payment{

    // Variables
    private BigDecimal amountPaid;

    // Constructors
    public Payment(BigDecimal amountPaid ) { //Call from child
        this.amountPaid = amountPaid;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    // Methods
    public String Describe() {
        return "Paid " + getAmountPaid();
    }

    @Override
    public String toString() {
        return Describe();
    }
}
