package code;
import java.io.Serial;
import java.io.Serializable;

public class Corporation extends Subscriber implements Serializable{
    private int bankCode;
    private String bankName;
    private int issueDay, issueMonth, issueYear;
    private int accountNumber;
    @Serial
    private static final long serialVersionUID = 1L;

    public Corporation(String name, String address, int bankCode, String bankName, int issueDay, int issueMonth, int issueYear, int accountNumber) {
        super(name, address);
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.issueDay = issueDay;
        this.issueMonth = issueMonth;
        this.issueYear = issueYear;
        this.accountNumber = accountNumber;
    }

    @Override
    public String getBillingInformation() {
        return "Name: " + name + "\nAddress: " + address + "\nBank Code: " + bankCode + "\nBank Name: " + bankName + "\nIssue Date: " + issueDay + "/" + issueMonth + "/" + issueYear + "\nAccount Number: " + accountNumber;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getIssueDay() {
        return issueDay;
    }

    public void setIssueDay(int issueDay) {
        this.issueDay = issueDay;
    }

    public int getIssueMonth() {
        return issueMonth;
    }

    public void setIssueMonth(int issueMonth) {
        this.issueMonth = issueMonth;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
