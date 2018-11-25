import java.math.BigDecimal;

public class Bill {
    private BigDecimal price;
    private BigDecimal balance;
    private boolean paidInFull;
    private Payment payment;

    public Bill() {
        this.price = new BigDecimal(0);
        this.balance = new BigDecimal(0);
        this.paidInFull = false;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        setBalance(price);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isPaidInFull() {
        return paidInFull;
    }

    public void setPaidInFull(boolean paidInFull) {
        this.paidInFull = paidInFull;
    }

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

    public String Describe() {
        return System.lineSeparator() + "Total Bill: $" + price + "\n" +
                "Balance: $" + balance;

    }
}
