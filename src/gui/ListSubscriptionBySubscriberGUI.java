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
public class ListSubscriptionBySubscriberGUI extends JFrame{
    private JTextField nameField;
    public ListSubscriptionBySubscriberGUI() {
        setTitle("List Subscription By Subscriber");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
    }
    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("List Subscription By Subscriber"));
        panel.add(createLabelAndTextField("Subscriber Name:", nameField = new JTextField(20)));
        JButton addButton = new JButton("List Subscription");
        addButton.addActionListener(e -> {
            Distributor distributor = new Distributor();
            distributor.loadState("serial.bin");
            if (distributor.searchSubscriber(nameField.getText()) != null) {
                dispose();
                new SubscriptionListFrame(distributor.searchSubscriber(nameField.getText())).setVisible(true);
                distributor.saveState("serial.bin");
            }
            else {
                JOptionPane.showMessageDialog(this, "Subscriber not found");
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
