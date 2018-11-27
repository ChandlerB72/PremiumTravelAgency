import java.math.BigDecimal;

/**
 * Object that implements the TripStatePayCreditCard
 */
public class PaymentCreditCard extends Payment{

    String creditCardNumber; /*<  Holds card number for payment*/

    //! Constructors
    public PaymentCreditCard(BigDecimal amountPaid, String creditCardNumber) {
        super(amountPaid);
        this.creditCardNumber = creditCardNumber;
    }

    //! Getter
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * @return Payment information via String
     */
    @Override
    public String Describe() {
        return super.Describe() + " via Credit Card (****" + creditCardNumber.substring(12) + ")";
    }
}
