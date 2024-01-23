package gui;
import code.Distributor;
import code.Corporation;
import code.Individual;
import code.Subscriber;
import javax.swing.*;
import java.awt.*;
public class EditFrame extends JFrame{
    private JTextField nameField, addressField, creditCardNrField, expireMonthField, expireYearField, CCVField;
    private JTextField bankCodeField, bankNameField, issueDayField, issueMonthField, issueYearField, accountNumberField;


    public EditFrame(Individual individual) {
        setTitle("Edit Individual Subscriber");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents(individual);
    }

    public EditFrame(Corporation corporation) {
        setTitle("Edit Corporation Subscriber");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents(corporation);
    }

    private void initializeComponents(Individual individual) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            // Individual subscriber components
            panel.add(new JLabel("Individual Subscriber"));
            panel.add(createLabelAndTextField("Name:", nameField = new JTextField(20)));
            panel.add(createLabelAndTextField("Address:", addressField = new JTextField(20)));
            panel.add(createLabelAndTextField("Credit Card Number:", creditCardNrField = new JTextField(20)));
            panel.add(createLabelAndTextField("Expire Month:", expireMonthField = new JTextField(20)));
            panel.add(createLabelAndTextField("Expire Year:", expireYearField = new JTextField(20)));
            panel.add(createLabelAndTextField("CCV:", CCVField = new JTextField(20)));

        JButton editButton = new JButton("Edit Information");
        editButton.addActionListener(e -> {
            Distributor distributor = new Distributor();
            distributor.loadState("serial.bin");

            Individual ind = (Individual) distributor.searchSubscriber(individual.getName());
            ind.setName(nameField.getText());
            ind.setAddress(addressField.getText());
            ind.setCreditCardNr(creditCardNrField.getText());
            ind.setExpireMonth(Integer.parseInt(expireMonthField.getText()));
            ind.setExpireYear(Integer.parseInt(expireYearField.getText()));
            ind.setCCV(Integer.parseInt(CCVField.getText()));

            distributor.saveState("serial.bin");

            dispose();
            new MainGUI().setVisible(true);
        });
        panel.add(editButton);

        add(panel);
    }

    private void initializeComponents(Corporation corporation) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

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

        JButton editButton = new JButton("Edit Information");
        editButton.addActionListener(e -> {
            Distributor distributor = new Distributor();
            distributor.loadState("serial.bin");

            Corporation cor = (Corporation) distributor.searchSubscriber(corporation.getName());
                cor.setName(nameField.getText());
                cor.setAddress(addressField.getText());
                cor.setBankCode(Integer.parseInt(bankCodeField.getText()));
                cor.setBankName(bankNameField.getText());
                cor.setIssueDay(Integer.parseInt(issueDayField.getText()));
                cor.setIssueMonth(Integer.parseInt(issueMonthField.getText()));
                cor.setIssueYear(Integer.parseInt(issueYearField.getText()));
                cor.setAccountNumber(Integer.parseInt(accountNumberField.getText()));

            distributor.saveState("serial.bin");

            dispose();
            new MainGUI().setVisible(true);
        });
        panel.add(editButton);

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
