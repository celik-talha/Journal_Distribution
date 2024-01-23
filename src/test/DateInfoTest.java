package test;
import code.*;
import junit.framework.TestCase;

public class DateInfoTest extends TestCase{
    private DateInfo dateInfo;

    public void setUp(){
        dateInfo = new DateInfo(7, 2023, 6);
    }

    public void testGetStartMonth(){
        assertEquals(7, dateInfo.getStartMonth());
    }

    public void testGetYear(){
        assertEquals(2023, dateInfo.getStartYear());
    }

    public void testGetEndMonth(){
        assertEquals(6, dateInfo.getEndMonth());
    }
}
