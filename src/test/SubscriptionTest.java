package test;
import code.*;
import junit.framework.TestCase;
public class SubscriptionTest extends TestCase{
    private Subscription subscription;
    private Journal journal;
    private Individual individual;
    private DateInfo dateInfo;
    private PaymentInfo paymentInfo;

    public void setUp(){
        journal = new Journal("Test Journal", "10", 6, 500.0);
        individual = new Individual("Test Individual", "Test Address",  "Test Credit Card Number", 1, 2027, 202);
        dateInfo = new DateInfo(1, 1, 2021);
        paymentInfo = new PaymentInfo(0.5);
        subscription = new Subscription(dateInfo, 2, journal, individual);
    }
    public void testGetDateInfo(){
        assertEquals(dateInfo, subscription.getDates());
    }
    public void testGetJournal(){
        assertEquals(journal, subscription.getJournal());
    }
    public void testGetSubscriber(){
        assertEquals(individual, subscription.getSubscriber());
    }
    public void testAcceptPayment(){
        subscription.acceptPayment(200);
        assertEquals(200.0, subscription.getPaymentInfo().getReceivedPayment());
        subscription.acceptPayment(50);
        assertEquals(250.0, subscription.getPaymentInfo().getReceivedPayment());
    }
}
