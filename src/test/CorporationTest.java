package test;
import code.Corporation;
import junit.framework.TestCase;

public class CorporationTest extends TestCase{
    private Corporation corporation;

    public void setUp(){
        corporation = new Corporation("Test Corporation", "Test Address", 123, "Test Bank", 1, 1, 2021, 123456);
    }

    public void testConstructor(){
        assertEquals("Test Corporation", corporation.getName());
        assertEquals("Test Address", corporation.getAddress());
        assertEquals(123, corporation.getBankCode());
        assertEquals("Test Bank", corporation.getBankName());
        assertEquals(1, corporation.getIssueDay());
        assertEquals(1, corporation.getIssueMonth());
        assertEquals(2021, corporation.getIssueYear());
        assertEquals(123456, corporation.getAccountNumber());
    }

    public void testGetName(){
        assertEquals("Test Corporation", corporation.getName());
    }

    public void testGetAddress(){
        assertEquals("Test Address", corporation.getAddress());
    }

    public void testSetName(){
        corporation.setName("New Test Corporation");
        assertEquals("New Test Corporation", corporation.getName());
    }

    public void testSetAddress(){
        corporation.setAddress("New Test Address");
        assertEquals("New Test Address", corporation.getAddress());
    }

}
