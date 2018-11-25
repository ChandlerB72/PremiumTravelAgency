import java.math.BigDecimal;

public class PaymentCash extends Payment {

    // Constructor
    public PaymentCash(BigDecimal amountPaid) {
        super(amountPaid);
    }

    // Methods
    @Override
    public String Describe() {
        return super.Describe() + " via Cash";
    }
}
