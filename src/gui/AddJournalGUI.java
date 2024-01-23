package gui;
import javax.swing.*;
import java.awt.*;
import code.Distributor;
import code.Corporation;
import code.Individual;
import code.Subscriber;
import code.Journal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddJournalGUI extends JFrame{
    //thats journal why are you adding a subscriber copilot
    //take my Journal class as an example

    private JTextField issnField, nameField, frequencyField, issuePriceField;

    public AddJournalGUI() {
        setTitle("Journal Information");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents();
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Journal Information"));
        panel.add(createLabelAndTextField("Name:", issnField = new JTextField(20)));
        panel.add(createLabelAndTextField("ISSN:", nameField = new JTextField(20)));
        panel.add(createLabelAndTextField("Frequency:", frequencyField = new JTextField(20)));
        panel.add(createLabelAndTextField("Issue Price:", issuePriceField = new JTextField(20)));

        JButton addButton = new JButton("Add Journal");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Journal journal = new Journal(issnField.getText(), nameField.getText(), Integer.parseInt(frequencyField.getText()), Double.parseDouble(issuePriceField.getText()));
                Distributor distributor = new Distributor();
                distributor.loadState("serial.bin");

                if (distributor.addJournal(journal)){
                    JOptionPane.showMessageDialog(null, "Journal added");
                }
                else{
                    JOptionPane.showMessageDialog(null, "This journal already exists");
                }
                distributor.saveState("serial.bin");
                dispose();
                new MainGUI().setVisible(true);
            }
        });
        panel.add(addButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainGUI().setVisible(true);
            }
        });
        panel.add(backButton);

        add(panel);
    }

    private JPanel createLabelAndTextField(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(labelText));
        panel.add(textField);
        return panel;
    }

}
