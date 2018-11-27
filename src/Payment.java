import java.math.BigDecimal;

/**
 * Payment is the object that holds all of the
 * information regarding amounts contributing
 * towards the bill for the Trip object.
 */
public class Payment{

    private BigDecimal amountPaid; /*< Amount the person is paying*/
    private Person personPaying; /*< Person object who is paying the payment*/

    //! Constructor
    public Payment(){}

    //! Constructor
    public Payment(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    //! Getters and Setters
    public BigDecimal getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    //! Getters and Setters
    public Person getPersonPaying() {
        return personPaying;
    }
    public void setPersonPaying(Person personPaying) {
        this.personPaying = personPaying;
    }


    /**
     * @return Description of payment
     */
    public String Describe() {
        return "Paid " + getAmountPaid();
    }

    /**
     * @return Payment information via String
     */
    @Override
    public String toString() {
        return Describe();
    }
}
