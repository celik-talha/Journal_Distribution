package test;
import code.Individual;
import junit.framework.TestCase;
public class IndividualTest extends TestCase{
    //there is no phone number in the constructor please be careful, take the constructor parameters from the code Individual.java
    private Individual individual;
    public void setUp(){
        individual = new Individual("Test Individual", "Test Address",  "Test Credit Card Number", 1, 2027, 202);
    }
    public void testConstructor(){
        assertEquals("Test Individual", individual.getName());
        assertEquals("Test Address", individual.getAddress());
        assertEquals("Test Credit Card Number", individual.getCreditCardNr());
        assertEquals(1, individual.getExpireMonth());
        assertEquals(2027, individual.getExpireYear());
        assertEquals(202, individual.getCCV());
    }
    public void testGetName(){
        assertEquals("Test Individual", individual.getName());
    }
    public void testGetAddress(){
        assertEquals("Test Address", individual.getAddress());
    }
    public void testGetCreditCardNr(){
        assertEquals("Test Credit Card Number", individual.getCreditCardNr());
    }
    public void testGetExpireMonth(){
        assertEquals(1, individual.getExpireMonth());
    }
    public void testGetExpireYear(){
        assertEquals(2027, individual.getExpireYear());
    }
    public void testGetCCV(){
        assertEquals(202, individual.getCCV());
    }
    public void testSetName(){
        individual.setName("New Test Individual");
        assertEquals("New Test Individual", individual.getName());
    }
    public void testSetAddress(){
        individual.setAddress("New Test Address");
        assertEquals("New Test Address", individual.getAddress());
    }
    public void testSetCreditCardNr(){
        individual.setCreditCardNr("New Test Credit Card Number");
        assertEquals("New Test Credit Card Number", individual.getCreditCardNr());
    }
    public void testSetExpireMonth(){
        individual.setExpireMonth(2);
        assertEquals(2, individual.getExpireMonth());
    }
    public void testSetExpireYear(){
        individual.setExpireYear(2028);
        assertEquals(2028, individual.getExpireYear());
    }
    public void testSetCCV(){
        individual.setCCV(203);
        assertEquals(203, individual.getCCV());
    }
}
