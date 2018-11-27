import java.math.BigDecimal;

/**
 * Object that implements the TripStatePayCash
 */
public class PaymentCash extends Payment {

    //! Constructor
    public PaymentCash(BigDecimal amountPaid, Person personPaying) {
        super(amountPaid, personPaying);
    }

    /**
     * @return Payment information via String
     */
    @Override
    public String Describe() {
        return super.Describe() + " via Cash";
    }
}
