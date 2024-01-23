package code;

import java.io.*;
import java.util.Hashtable;
import java.util.Vector;
import java.io.FileInputStream;

public class Distributor implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private Hashtable<String, Journal> journals = new Hashtable<String, Journal>();
    private Vector<Subscriber> subscribers = new Vector<Subscriber>();

    public boolean addJournal(Journal _journal){
        if(journals.containsKey(_journal.getIssn())){
            return false;
        }
        else{
            journals.put(_journal.getIssn(), _journal);
            return true;
        }
    }
    public boolean deleteJournal(String issn){
        if(journals.containsKey(issn)){
            journals.remove(issn);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean addSubscriber(Subscriber _subscriber){
        if(subscribers.contains(_subscriber)){
            return false;
        }
        else{
            subscribers.add(_subscriber);
            return true;
        }
    }

    public Journal searchJournal(String issn){
        if(journals.containsKey(issn)){
            return journals.get(issn);
        }
        else{
            return null;
        }
    }

    public Individual searchIndividual(String name){
        for (Subscriber individual : subscribers) {
            if (individual.getName().equals(name)) {
                return (Individual) individual;
            }
        }
        return null;
    }

    public Corporation searchCorporation(String name){
        for (Subscriber corporation : subscribers) {
            if (corporation.getName().equals(name)) {
                return (Corporation) corporation;
            }
        }
        return null;
    }
    public Subscriber searchSubscriber(String name){
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getName().equals(name)) {
                return subscriber;
            }
        }
        return null;
    }

    public boolean addSubscription(String _issn, Subscriber _subscriber, Subscription _subscription){
        if (!journals.containsKey(_issn) && !subscribers.contains(_subscriber)){
            return false;
        }
        else{
            Journal journal = journals.get(_issn);
            if(journal.getSubscriptions().contains(_subscription)){
                _subscription.increaseCopies(1);
            }
            else{
                journal.addSubscription(_subscription);
            }
            return true;
        }

    }

    public String listAllSendingOrders(int month, int year){
        for (Journal journal : journals.values()) {
            for (Subscription subscription : journal.getSubscriptions()) {
                if(subscription.canSend(month,year)){
                    return("Journal: " + journal.getName() + "\nSubscriber: " + subscription.getSubscriber().getName() + "\nCopies: " + subscription.getCopies() + "\n");
                }
            }
        }
        return "No sending orders.";
    }

    public String listSendingOrders(String issn, int month, int year){
        Journal journal = journals.get(issn);
        for (Subscription subscription : journal.getSubscriptions()) {
            if(subscription.canSend(month,year)){
                return("Journal: " + journal.getName() + "\nSubscriber: " + subscription.getSubscriber().getName() + "\nCopies: " + subscription.getCopies() + "\n");
            }
        }
        return "No sending orders.";
    }

    public String listIncompletePayments(){
        for (Journal journal : journals.values()) {
            for(Subscription subscription : journal.getSubscriptions()){
                if((subscription.getPayment().getReceivedPayment() / (journal.getIssuePrice() * (1- subscription.getPayment().getDiscountRatio()))) < subscription.getCopies()){
                    return ("Journal: " + journal.getName() + "\nSubscriber: " + subscription.getSubscriber().getName() + "\nCopies: " + subscription.getCopies() + "\n" + "Received Payment: " + subscription.getPayment().getReceivedPayment() + "\n" + "Required Payment: " + (journal.getIssuePrice() * (1-subscription.getPayment().getDiscountRatio()) * subscription.getCopies() + "\n"));
                }
            }
        }
        return "No incomplete payments.";
    }

    public void listSubscriptions(String subscriberName){
        Subscriber subscriber = searchSubscriber(subscriberName);
        for (Journal journal : journals.values()) {
            for (Subscription subscription : journal.getSubscriptions()) {
                if(subscription.getSubscriber().equals(subscriber)){
                    System.out.println("Journal: " + journal.getName() + "\nCopies: " + subscription.getCopies() + "\n");
                }
            }
        }
    }

    public void listSubscriptionsByIssn(String issn){
        Journal journal = journals.get(issn);
        for (Subscription subscription : journal.getSubscriptions()) {
            System.out.println("Subscriber: " + subscription.getSubscriber().getName() + "\nCopies: " + subscription.getCopies() + "\n");
        }
    }
    public boolean deleteSubscriber(String name){
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getName().equals(name)) {
                subscribers.remove(subscriber);
                return true;
            }
        }
        return false;
    }

    public Vector<Subscriber> getSubscribers(){
        return subscribers;
    }
    public Hashtable<String, Journal> getJournals(){
        return journals;
    }
    public void saveState(String filename){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial.bin"))){
            oos.writeObject(this);
            oos.close();

            //System.out.println("Succesfully saved to " + filename);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void loadState(String filename){
        if (!new File("serial.bin").exists()){
            return;
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial.bin"))){
            Distributor distributor = (Distributor) ois.readObject();
            this.subscribers = distributor.getSubscribers();
            this.journals = distributor.getJournals();
            ois.close();

            //System.out.println("Succesfully loaded from " + filename);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void report(){

    }

    public void main(String[] args) {
        Distributor distributor = new Distributor();
        distributor.loadState("serial.bin");
    }

}
