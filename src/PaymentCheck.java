import java.math.BigDecimal;

/**
 * Object that implements the TripStatePayCheck
 */
public class PaymentCheck extends Payment{

    private int checkNumber; /*<  Holds check number for payment*/

    //! Constructor
    public PaymentCheck(BigDecimal amountPaid, int checkNumber) {
        super(amountPaid);
        this.checkNumber = checkNumber;
    }

    //! Getter
    public int getCheckNumber() {
        return checkNumber;
    }

    /**
     * @return Payment information via String
     */
    @Override
    public String Describe() {
        return super.Describe() + " via Check (" + checkNumber + ")";
    }
}
