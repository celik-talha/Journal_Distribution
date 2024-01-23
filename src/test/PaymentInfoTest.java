package test;
import code.*;
import junit.framework.TestCase;

public class PaymentInfoTest extends TestCase{
    private PaymentInfo paymentInfo;

    public void setUp(){
        paymentInfo = new PaymentInfo(0.5);
    }

    public void testGetDiscount(){
        assertEquals(0.5, paymentInfo.getDiscountRatio());
    }

    public void testGetReceivedPayment(){
        assertEquals(0.0, paymentInfo.getReceivedPayment());
        Subscription subscription = new Subscription(new DateInfo(1, 1, 2021), 2, new Journal("Test Journal", "10", 6, 500.0), new Individual("Test Individual", "Test Address",  "Test Credit Card Number", 1, 2027, 202));
        subscription.acceptPayment(200);
        assertEquals(200.0, subscription.getPaymentInfo().getReceivedPayment());
    }

    public void testIncreasePayment(){
        paymentInfo.increasePayment(400);
        assertEquals(400.0, paymentInfo.getReceivedPayment());
        paymentInfo.increasePayment(50);
        assertEquals(450.0, paymentInfo.getReceivedPayment());
    }
}