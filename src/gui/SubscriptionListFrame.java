package gui;
import code.Distributor;
import code.Corporation;
import code.Individual;
import code.Subscriber;
import code.Subscription;
import code.Journal;
import code.PaymentInfo;
import code.DateInfo;
import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class SubscriptionListFrame extends JFrame{
    private JTextField issnField;
    public SubscriptionListFrame(Journal journal) {
        setTitle("List Subscription By Journal");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents(journal);
    }
    public SubscriptionListFrame(Subscriber subscriber) {
        setTitle("List Subscription By Subscriber");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents(subscriber);
    }

    private void initializeComponents(Journal journal) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("List Subscription By Journal"));

        for(Subscription subscription : journal.getSubscriptions()){
            panel.add(new JLabel("Subscriber Name: " + subscription.getSubscriber().getName()));
            panel.add(new JLabel("Journal ISSN: " + subscription.getJournal().getIssn()));
            panel.add(new JLabel("Address: " + subscription.getSubscriber().getAddress()));
            panel.add(new JLabel("Copies: " + (subscription.getCopies())));
            panel.add(new JLabel("Start Date: " + String.valueOf(subscription.getDates().getStartMonth()) + "/" + String.valueOf(subscription.getDates().getStartYear())));
            panel.add(new JLabel("End Date: " + String.valueOf(subscription.getDates().getEndMonth()) + "/" + String.valueOf(subscription.getDates().getStartYear()+1)));
            panel.add(new JLabel("Received Payments: " + subscription.getPayment().getReceivedPayment()));
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new MainGUI().setVisible(true);
        });
        panel.add(backButton);
        add(panel);
    }
    private void initializeComponents(Subscriber subscriber) {
        //distributordeki journal listesini gez, o listedeki her bir journalin subscription listesini gez, eğer o subscriptionın subscriberı bu subscriber ise onu yazdır
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("List Subscription By Subscriber"));

        Distributor distributor = new Distributor();
        distributor.loadState("serial.bin");

        Hashtable<String, Journal> journalList = distributor.getJournals();
        for (String issn : journalList.keySet()) {
            Journal journal = journalList.get(issn);
            for (Subscription subscription : journal.getSubscriptions()) {
                if (subscription.getSubscriber().getName().equals(subscriber.getName())) {
                    panel.add(new JLabel("Subscriber Name: " + subscription.getSubscriber().getName()));
                    panel.add(new JLabel("Journal ISSN: " + subscription.getJournal().getIssn()));
                    panel.add(new JLabel("Address: " + subscription.getSubscriber().getAddress()));
                    panel.add(new JLabel("Copies: " + (subscription.getCopies())));
                    panel.add(new JLabel("Start Date: " + String.valueOf(subscription.getDates().getStartMonth()) + "/" + String.valueOf(subscription.getDates().getStartYear())));
                    panel.add(new JLabel("End Date: " + String.valueOf(subscription.getDates().getEndMonth()) + "/" + String.valueOf(subscription.getDates().getStartYear()+1)));
                    panel.add(new JLabel("Received Payments: " + subscription.getPayment().getReceivedPayment()));
                    panel.add(Box.createRigidArea(new Dimension(0, 10)));
                }
            }
        }
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new MainGUI().setVisible(true);
        });
        panel.add(backButton);
        add(panel);
        add(new JScrollPane(panel));
    }

    private JPanel createLabelAndTextField(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel.add(new JLabel(labelText));
        panel.add(textField);
        return panel;
    }
}
