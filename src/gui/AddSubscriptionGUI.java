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
public class AddSubscriptionGUI extends JFrame{
    private JTextField nameField, issnField, startMonthField, startYearField, endMonthField, endYearField, copiesField;
    public AddSubscriptionGUI() {
        setTitle("Add Subscription");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
    }
    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Add Subscription"));
        panel.add(createLabelAndTextField("Subscriber Name:", nameField = new JTextField(20)));
        panel.add(createLabelAndTextField("Journal ISSN:", issnField = new JTextField(20)));
        panel.add(createLabelAndTextField("Start Month:", startMonthField = new JTextField(20)));
        panel.add(createLabelAndTextField("Start Year:", startYearField = new JTextField(20)));
        panel.add(createLabelAndTextField("Copies:", copiesField = new JTextField(20)));
        JButton addButton = new JButton("Add Subscription");

        addButton.addActionListener(e -> {
            Distributor distributor = new Distributor();
            distributor.loadState("serial.bin");
            if (distributor.searchSubscriber(nameField.getText()) != null) {
                if (distributor.searchJournal(issnField.getText()) != null) {
                    if (distributor.searchSubscriber(nameField.getText()) instanceof Individual) {
                        DateInfo dateInfo = new DateInfo(Integer.parseInt(startMonthField.getText()), Integer.parseInt(startYearField.getText()), Integer.parseInt(startMonthField.getText()));
                        Subscription subscription = new Subscription(dateInfo, Integer.parseInt(copiesField.getText()), distributor.searchJournal(issnField.getText()), (Individual) distributor.searchSubscriber(nameField.getText()));

                        distributor.addSubscription(issnField.getText(), (Individual) distributor.searchSubscriber(nameField.getText()), subscription);
                        distributor.saveState("serial.bin");

                        dispose();
                        JOptionPane.showMessageDialog(this, "Subscription added");
                        new MainGUI().setVisible(true);

                    } else if (distributor.searchSubscriber(nameField.getText()) instanceof Corporation) {
                        DateInfo dateInfo = new DateInfo(Integer.parseInt(startMonthField.getText()), Integer.parseInt(startYearField.getText()), Integer.parseInt(startMonthField.getText()));
                        Subscription subscription = new Subscription(dateInfo, Integer.parseInt(copiesField.getText()), distributor.searchJournal(issnField.getText()), (Corporation) distributor.searchSubscriber(nameField.getText()));

                        distributor.addSubscription(issnField.getText(), (Corporation) distributor.searchSubscriber(nameField.getText()), subscription);
                        distributor.saveState("serial.bin");
                        dispose();
                        JOptionPane.showMessageDialog(this, "Subscription added");
                        new MainGUI().setVisible(true);

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
