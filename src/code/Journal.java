package code;

import java.io.Serial;
import java.util.ArrayList;
import java.io.Serializable;

public class Journal implements Serializable{
    private String name,issn;
    private int frequency;
    private double issuePrice;
    @Serial
    private static final long serialVersionUID = 1L;
    private ArrayList<Subscription> subscriptions = new ArrayList<Subscription>();

    public Journal(String name, String issn, int frequency, double issuePrice) {
        this.name = name;
        this.issn = issn;
        this.frequency = frequency;
        this.issuePrice = issuePrice;
    }

    public void addSubscription(Subscription _subscription){
        subscriptions.add(_subscription);
    }

    public double getIssuePrice(){
        return issuePrice;
    }

    public String getIssn(){
        return issn;
    }
    public String getName(){
        return name;
    }
    public int getFrequency(){
        return frequency;
    }

    public void setName(String _name){
        name = _name;
    }
    public void setFrequency(int _frequency){
        frequency = _frequency;
    }
    public void setIssuePrice(double _issuePrice){
        issuePrice = _issuePrice;
    }
    public void setIssn(String _issn){
        issn = _issn;
    }



    public boolean searchSubscription(Subscriber _subscriber){
        for (Subscription subscription : subscriptions) {
            if (subscription.getSubscriber().equals(_subscriber)) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Subscription> getSubscriptions(){
        return subscriptions;
    }

}
