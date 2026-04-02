package ucen.uk.alessiouniversityhall;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents a payment for student accommodation.
 * It stores the rent amount and the date when the payment was created.
 * This class implements Serializable so payment data can be saved
 * and loaded from a text file.
 *
 * @author Alessio
 */
public class Payment implements Serializable {

    private final double rent;
    private final Date paymentDate;

    /**
     * Constructs a new Payment with rent amount and current date.
     *
     * @param rent amount in GBP
     */
    public Payment(double rent) {
        this.rent = rent;
        this.paymentDate = new Date();
    }

    /**
     * Returns the rent amount.
     *
     * @return rent
     */
    public double getRent() {
        return rent;
    }

    /**
     * Returns the payment date.
     *
     * @return payment date
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * Returns a formatted string representation of the payment.
     * Includes rent and payment date.
     *
     * @return formatted payment information
     */
    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return "Rent: £" + rent +
                "\nPayment Date: " + sdf.format(paymentDate);
    }
}
