import java.math.BigDecimal;
import java.util.Date;

public class PaymentCreditCard extends Payment{

    // Variables
    String creditCardNumber;

    // Constructors
    public PaymentCreditCard(BigDecimal amountPaid, String creditCardNumber) {
        super(amountPaid);
        this.creditCardNumber = creditCardNumber;
    }

    // Getters and Setters
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    // Methods
    @Override
    public String Describe() {
        return super.Describe() + " via Credit Card (****" + creditCardNumber.substring(12) + ")";
    }
}
