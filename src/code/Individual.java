package code;
import java.io.Serial;
import java.io.Serializable;

public class Individual extends Subscriber implements Serializable{
    private String creditCardNr;
    private int expireMonth, expireYear;
    private int CCV;
    @Serial
    private static final long serialVersionUID = 1L;

    public Individual(String name, String address, String creditCardNr, int expireMonth, int expireYear, int CCV) {
        super(name, address);
        this.creditCardNr = creditCardNr;
        this.expireMonth = expireMonth;
        this.expireYear = expireYear;
        this.CCV = CCV;
    }

    @Override
    public String getBillingInformation() {
        return "Name: " + name + "\nAddress: " + address + "\nCredit Card Number: " + creditCardNr + "\nExpire Date: " + expireMonth + "/" + expireYear + "\nCCV: " + CCV;
    }

    public String getCreditCardNr() {
        return creditCardNr;
    }

    public void setCreditCardNr(String creditCardNr) {
        this.creditCardNr = creditCardNr;
    }

    public int getExpireMonth() {
        return expireMonth;
    }

    public void setExpireMonth(int expireMonth) {
        this.expireMonth = expireMonth;
    }

    public int getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(int expireYear) {
        this.expireYear = expireYear;
    }

    public int getCCV() {
        return CCV;
    }

    public void setCCV(int CCV) {
        this.CCV = CCV;
    }
}
