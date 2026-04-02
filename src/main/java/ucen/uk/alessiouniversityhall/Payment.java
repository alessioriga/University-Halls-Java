package ucen.uk.alessiouniversityhall;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment implements Serializable {
    private final double rent;
    private final Date paymentDate;

    public Payment(double rent) {
        this.rent = rent;
        this.paymentDate = new Date();
    }

    public double getRent() {
        return rent;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return "Rent: £" + rent +
                "\nPayment Date: " + sdf.format(paymentDate);
    }
}
