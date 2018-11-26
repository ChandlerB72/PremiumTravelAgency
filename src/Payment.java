import java.math.BigDecimal;

public class Payment{

    // Variables
    private BigDecimal amountPaid;
    private Person personPaying;

    // Constructor
    public Payment(){}

    public Payment(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    // Getters and Setters
    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Person getPersonPaying() {
        return personPaying;
    }

    public void setPersonPaying(Person personPaying) {
        this.personPaying = personPaying;
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
