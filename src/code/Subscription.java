package code;
import java.io.Serial;
import java.io.Serializable;
public class Subscription implements Serializable{
    private final DateInfo dates;
    private PaymentInfo payment;
    private int copies = 1;
    private final Journal journal;
    private final Subscriber subscriber;

    //Today is 01/2024
    private int thiMonth = 1;
    private int thisYear = 2024;
    @Serial
    private static final long serialVersionUID = 1L;

    public Subscription(DateInfo dates, int number, Journal journal, Subscriber subscriber){
        this.dates = dates;
        this.copies = number;
        this.journal = journal;
        this.subscriber = subscriber;

        if(subscriber instanceof Corporation){
            payment = new PaymentInfo(0.5);
        }
        else{
            payment = new PaymentInfo(0);
        }

    }

    public void acceptPayment(double amount){
        payment.increasePayment(amount);
    }

    public boolean canSend(int issueMonth, int issueYear){
        if((payment.getReceivedPayment() / (journal.getIssuePrice() * (1-payment.getDiscountRatio()) )) >= copies){
            System.out.println("asdas");
            System.out.println(dates.getStartYear() +"---" + issueYear +"---" + dates.getStartMonth() +"---" + issueMonth);
            if (dates.getStartYear() == issueYear){
                if(dates.getStartMonth() <= issueMonth){
                    System.out.println("true1");
                    return true;
                }
                else{
                    System.out.println("false2");
                    return false;
                }
            }
            else if(dates.getStartYear() == issueYear-1){
                if(dates.getEndMonth() >= issueMonth){
                    System.out.println("true3");
                    return true;
                }
                System.out.println("2345");
            }

        }
        return false;
    }
    public PaymentInfo getPayment(){
        return payment;
    }
    public int getCopies(){
        return copies;
    }
    public void increaseCopies(int number){
        copies += number;
    }

    public Subscriber getSubscriber(){
        return subscriber;
    }
    public Journal getJournal(){
        return journal;
    }
    public DateInfo getDates(){
        return dates;
    }

    public PaymentInfo getPaymentInfo(){
        return payment;
    }


}
