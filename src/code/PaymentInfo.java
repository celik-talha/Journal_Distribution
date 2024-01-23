package code;
import java.io.Serial;
import java.io.Serializable;
public class PaymentInfo implements Serializable{
    private final double discountRatio;
    private double receivedPayment;
    @Serial
    private static final long serialVersionUID = 1L;

    public PaymentInfo(double discountRatio){
        this.discountRatio = discountRatio;
    }

    public void increasePayment(double amount){
        receivedPayment += amount;
    }

    public double getReceivedPayment(){
        return receivedPayment;
    }

    public double getDiscountRatio(){
        return discountRatio;
    }
}
