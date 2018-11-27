import java.math.BigDecimal;

/**
 * Bill is the object that holds all of the pricing
 * and payment information for the Trip object.
 */
public class Bill {

    private BigDecimal price; /*!< Holds the total price of the trip*/
    private BigDecimal balance; /*!< Holds the current balance of the trip*/
    private boolean paidInFull; /*!< Holds if trip paid in full*/
    private Payment payment; /*!< Holds payment object*/

    //! Constructor
    public Bill() {
        this.price = new BigDecimal(0);
        this.balance = new BigDecimal(0);
        this.paidInFull = false;
        this.payment = new Payment();
    }

    //! Getter and Setter
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
        setBalance(price);
    }

    //! Getter and Setter
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    //! Getter and Setter
    public boolean isPaidInFull() {
        return paidInFull;
    }
    public void setPaidInFull(boolean paidInFull) {
        this.paidInFull = paidInFull;
    }

    //! Getter and Setter
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;

        int logic = payment.getAmountPaid().compareTo(getBalance());
        if (logic == 1) // First value is greater - Overpay
            System.out.println("ERROR: You can not pay more than the bill requires.");
        if (logic == -1) // Second value is greater - Partial Pay
            setBalance(getBalance().subtract(payment.getAmountPaid()));
        if (logic == 0) // Values are equal - Paid in Full
            setPaidInFull(true);
    }

    /**
     * @return String that describes the bill price and balance
     */
    public String Describe() {
        return System.lineSeparator() + "Total Bill: $" + price + "\n" +
                "Balance: $" + balance;

    }
}
