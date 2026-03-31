package ucen.uk.alessiouniversityhall;

import java.util.Date;

public class Payment {
    private double rent;
    private Date paymentDate;

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
}
