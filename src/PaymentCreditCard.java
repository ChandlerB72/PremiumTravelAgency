import java.math.BigDecimal;
import java.util.Date;

public class PaymentCreditCard extends Payment{

    // Variables
    String creditCardNumber;
    Date expirationDate;

    // Constructors
    public PaymentCreditCard(BigDecimal amount, String creditCardNumber, Date expirationDate) {
        super(amount);
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
    }

    // Getters and Setters
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    // Methods
    @Override
    public String Describe() {
        return super.Describe() + "via Credit Card (****" + creditCardNumber.substring(12) + ")";
    }
}
