package gui;
import code.*;
import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class ExpiredSubscriptionGUI extends JFrame{
    private JTextField monthField, yearField;
    public ExpiredSubscriptionGUI() {
        setTitle("Expired Subscriptions");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents();
    }
    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(25));

        panel.add(new JLabel("Search With Date"));
        panel.add(createLabelAndTextField("Month:", monthField = new JTextField(20)));
        panel.add(createLabelAndTextField("Year:", yearField = new JTextField(20)));

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {
            Distributor distributor = new Distributor();
            distributor.loadState("serial.bin");

            String msg = "";

            Hashtable<String, Journal> journals = distributor.getJournals();
            for (Journal journal : journals.values()) {
                for (Subscription subscription : journal.getSubscriptions()) {
                    if ((subscription.getDates().getStartYear() + 1) < Integer.parseInt(yearField.getText())) {
                        msg += subscription.getSubscriber().getName() + "-" + journal.getName() + "-" + "Expiration Date:" +  subscription.getDates().getEndMonth() + "/" + (subscription.getDates().getStartYear()+1)   + "\n";
                    } else if ((subscription.getDates().getStartYear() + 1) == Integer.parseInt(yearField.getText())) {
                        if (subscription.getDates().getEndMonth() < Integer.parseInt(monthField.getText())) {
                            msg += subscription.getSubscriber().getName() + "-" + journal.getName() + "-" + "Expiration Date:" +  subscription.getDates().getEndMonth() + "/" + (subscription.getDates().getStartYear()+1)   + "\n";
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(this, msg);
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new ReportGUI().setVisible(true);
        });
        panel.add(searchButton);
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
