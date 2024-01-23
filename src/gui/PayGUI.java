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
import java.util.ArrayList;
import java.util.Hashtable;

public class PayGUI extends JFrame{
    private JTextField nameField, issnField, startMonthField, startYearField, endMonthField, endYearField, copiesField, paymentAmountField, paymentDateField;
    public PayGUI() {
        setTitle("Pay");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
    }
    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Pay"));
        panel.add(createLabelAndTextField("Subscriber Name:", nameField = new JTextField(20)));
        panel.add(createLabelAndTextField("Journal ISSN:", issnField = new JTextField(20)));
        panel.add(createLabelAndTextField("Payment Amount:", paymentAmountField = new JTextField(20)));
        JButton addButton = new JButton("Pay");
        addButton.addActionListener(e -> {
            Distributor distributor = new Distributor();
            distributor.loadState("serial.bin");

            Hashtable<String, Journal> journalList = distributor.getJournals();
            for (String issn : journalList.keySet()) {
                Journal _journal = journalList.get(issn);
                ArrayList<Subscription> subscriptionList = _journal.getSubscriptions();
                for (Subscription subscription : subscriptionList) {
                    if (subscription.getSubscriber().getName().equals(nameField.getText())) {
                        if (subscription.getJournal().getIssn().equals(issnField.getText())) {
                            subscription.getPaymentInfo().increasePayment(Double.parseDouble(paymentAmountField.getText()));
                            JOptionPane.showMessageDialog(this, "Payment made");
                            distributor.saveState("serial.bin");
                            dispose();
                            new MainGUI().setVisible(true);
                        }
                    }
                }
            }

        });
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new MainGUI().setVisible(true);
        });
        panel.add(addButton);
        panel.add(backButton);
        add(panel);

    }

    private JPanel createLabelAndTextField(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel.add(new JLabel(labelText));
        panel.add(textField);
        return panel;
    }
}
