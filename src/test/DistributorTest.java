package test;
import code.*;
import junit.framework.TestCase;

public class DistributorTest extends TestCase{
    private Distributor distributor;
    private Journal journal;
    private Individual individual;
    private DateInfo dateInfo;
    private PaymentInfo paymentInfo;
    private Subscription subscription;

    public void setUp(){
        journal = new Journal("Test Journal", "10", 6, 500.0);
        individual = new Individual("Test Individual", "Test Address",  "Test Credit Card Number", 3, 2030, 145);
        dateInfo = new DateInfo(4, 2028, 3);
        paymentInfo = new PaymentInfo(0.5);
        subscription = new Subscription(dateInfo, 1, journal, individual);
        distributor = new Distributor();
    }
    public void testAddJournal(){
        distributor.addJournal(journal);
        assertEquals(journal, distributor.searchJournal(journal.getIssn()));
    }
    public void testSearchJournal(){
        distributor.addJournal(journal);
        assertEquals(journal, distributor.searchJournal(journal.getIssn()));
    }
    public void testAddSubscriber(){
        distributor.addSubscriber(individual);
        assertEquals(individual, distributor.searchSubscriber(individual.getName()));
    }
    public void testSearchSubscriber(){
        distributor.addSubscriber(individual);
        assertEquals(individual, distributor.searchSubscriber(individual.getName()));
    }
    public void testAddSubscription(){
        distributor.addJournal(journal);
        distributor.addSubscriber(individual);
        distributor.addSubscription("10",individual,subscription);
        assertEquals(subscription,distributor.searchJournal(journal.getIssn()).getSubscriptions().get(0));
    }
}
