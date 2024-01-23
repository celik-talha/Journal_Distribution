package gui;
import code.*;
import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class ListAllSendingOrdersGUI extends JFrame{
    private JTextField monthField, yearField;
    public ListAllSendingOrdersGUI() {
        setTitle("List All Sending Orders By Month/Year");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
    }
    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("List All Sending Orders By Month/Year"));
        panel.add(createLabelAndTextField("Month:", monthField = new JTextField(20)));
        panel.add(createLabelAndTextField("Year:", yearField = new JTextField(20)));
        JButton addButton = new JButton("List Sending Orders");
        addButton.addActionListener(e -> {
            Distributor distributor = new Distributor();
            distributor.loadState("serial.bin");
            Hashtable<String, Journal> journals = distributor.getJournals();
            for (Journal journal : journals.values()) {
                if (journal.getSubscriptions() != null) {
                    for (Subscription subscription : journal.getSubscriptions()) {
                        if (subscription.canSend(Integer.parseInt(monthField.getText()), Integer.parseInt(yearField.getText()))) {
                            String infoMessage =( "Name: " + subscription.getSubscriber().getName() +
                                    "\nAddress: " + subscription.getSubscriber().getAddress() +
                                    "\nSubscription Date: " + subscription.getDates().getStartMonth() + "/" +
                                    subscription.getDates().getStartYear()  + " - " + subscription.getDates().getEndMonth() + "/" +
                                    (subscription.getDates().getStartYear() + 1));
                            JOptionPane.showMessageDialog(null, infoMessage);
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
