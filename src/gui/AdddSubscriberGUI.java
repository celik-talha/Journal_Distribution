package gui;
import javax.swing.*;
import java.awt.*;
import code.Distributor;
import code.Corporation;
import code.Individual;
import code.Subscriber;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdddSubscriberGUI extends JFrame {

    private JTextField nameField, addressField, creditCardNrField, expireMonthField, expireYearField, CCVField;
    private JTextField bankCodeField, bankNameField, issueDayField, issueMonthField, issueYearField, accountNumberField;

    public AdddSubscriberGUI() {
        setTitle("Subscriber Information");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents();
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Ask if Individual or Corporation
        String[] options = {"Individual", "Corporation"};
        int choice = JOptionPane.showOptionDialog(this, "Choose subscriber type:", "Subscriber Type",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            // Individual subscriber components
            panel.add(new JLabel("Individual Subscriber"));
            panel.add(createLabelAndTextField("Name:", nameField = new JTextField(20)));
            panel.add(createLabelAndTextField("Address:", addressField = new JTextField(20)));
            panel.add(createLabelAndTextField("Credit Card Number:", creditCardNrField = new JTextField(20)));
            panel.add(createLabelAndTextField("Expire Month:", expireMonthField = new JTextField(20)));
            panel.add(createLabelAndTextField("Expire Year:", expireYearField = new JTextField(20)));
            panel.add(createLabelAndTextField("CCV:", CCVField = new JTextField(20)));
        } else if (choice == 1) {
            // Corporation subscriber components
            panel.add(new JLabel("Corporation Subscriber"));
            panel.add(createLabelAndTextField("Name:", nameField = new JTextField(20)));
            panel.add(createLabelAndTextField("Address:", addressField = new JTextField(20)));
            panel.add(createLabelAndTextField("Bank Code:", bankCodeField = new JTextField(20)));
            panel.add(createLabelAndTextField("Bank Name:", bankNameField = new JTextField(20)));
            panel.add(createLabelAndTextField("Issue Day:", issueDayField = new JTextField(20)));
            panel.add(createLabelAndTextField("Issue Month:", issueMonthField = new JTextField(20)));
            panel.add(createLabelAndTextField("Issue Year:", issueYearField = new JTextField(20)));
            panel.add(createLabelAndTextField("Account Number:", accountNumberField = new JTextField(20)));
        }

        JButton addButton = new JButton("Add Information");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (choice == 0) {
                    Individual individual = new Individual(nameField.getText(), addressField.getText(),
                            creditCardNrField.getText(), Integer.parseInt(expireMonthField.getText()),
                            Integer.parseInt(expireYearField.getText()), Integer.parseInt(CCVField.getText()));
                    addSubscriberToDistributor(individual);
                } else if (choice == 1) {
                    Corporation corporation = new Corporation(nameField.getText(), addressField.getText(),
                            Integer.parseInt(bankCodeField.getText()), bankNameField.getText(), Integer.parseInt(issueDayField.getText()),
                            Integer.parseInt(issueMonthField.getText()), Integer.parseInt(issueYearField.getText()),
                            Integer.parseInt(accountNumberField.getText()));
                    addSubscriberToDistributor(corporation);
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new MainGUI().setVisible(true);
        });
        panel.add(backButton);
        panel.add(addButton);

        add(panel);
    }

    private JPanel createLabelAndTextField(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel.add(new JLabel(labelText));
        panel.add(textField);
        return panel;
    }

    private void addSubscriberToDistributor(Corporation corporation) {
        Distributor distributor = new Distributor();
        distributor.loadState("serial.bin");
        distributor.addSubscriber(corporation);
        distributor.saveState("serial.bin");
        JOptionPane.showMessageDialog(this, "Corporation Subscriber added");
        dispose();
        new MainGUI().setVisible(true);
    }

    private void addSubscriberToDistributor(Individual individual) {
        Distributor distributor = new Distributor();
        distributor.loadState("serial.bin");
        distributor.addSubscriber(individual);
        distributor.saveState("serial.bin");
        JOptionPane.showMessageDialog(this, "Individual Subscriber added");
        dispose();
        new MainGUI().setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdddSubscriberGUI().setVisible(true);
            }
        });
    }
}
