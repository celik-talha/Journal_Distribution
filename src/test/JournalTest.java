package test;
import code.*;
import junit.framework.TestCase;

import java.util.Date;

public class JournalTest extends TestCase{
    private Journal journal;
    public void setUp(){
        journal = new Journal("Test Journal", "10", 6, 500.0);
    }
    public void testGetName(){
        assertEquals("Test Journal", journal.getName());
    }
    public void testGetIssn(){
        assertEquals("10", journal.getIssn());
    }
    public void testGetIssue(){
        assertEquals(500.0, journal.getIssuePrice());
    }
    public void testGetFrequency(){
        assertEquals(6, journal.getFrequency());
    }
    public void testSetName(){
        journal.setName("New Test Journal");
        assertEquals("New Test Journal", journal.getName());
    }
    public void testSetIssn(){
        journal.setIssn("11");
        assertEquals("11", journal.getIssn());
    }
    public void testSetIssue(){
        journal.setIssuePrice(600.0);
        assertEquals(600.0, journal.getIssuePrice());
    }
    public void testSetFrequency(){
        journal.setFrequency(7);
        assertEquals(7, journal.getFrequency());
    }
    public void testAddSubscription(){
        Individual individual = new Individual("Test Individual", "Test Address",  "Test Credit Card Number", 1, 2027, 202);
        DateInfo dateInfo = new DateInfo(1, 1, 2021);
        Subscription subscription = new Subscription(dateInfo, 2, journal, individual);
        journal.addSubscription(subscription);
        assertEquals(true, journal.searchSubscription(subscription.getSubscriber()));
    }

}
