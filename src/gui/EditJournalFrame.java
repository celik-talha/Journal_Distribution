package gui;
import javax.swing.*;
import java.awt.*;
import code.Distributor;
import code.Corporation;
import code.Individual;
import code.Subscriber;
import code.Journal;


public class EditJournalFrame extends JFrame{
    private JTextField issnField, nameField, frequencyField, issuePriceField;

    public EditJournalFrame(Journal journal) {
        setTitle("Edit Journal");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents(journal);
    }

    private void initializeComponents(Journal journal) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Journal Information"));
        panel.add(createLabelAndTextField("ISSN:", issnField = new JTextField(20)));
        issnField.setText(journal.getIssn());
        panel.add(createLabelAndTextField("Name:", nameField = new JTextField(20)));
        nameField.setText(journal.getName());
        panel.add(createLabelAndTextField("Frequency:", frequencyField = new JTextField(20)));
        frequencyField.setText(String.valueOf(journal.getFrequency()));
        panel.add(createLabelAndTextField("Issue Price:", issuePriceField = new JTextField(20)));
        issuePriceField.setText(String.valueOf(journal.getIssuePrice()));

        JButton addButton = new JButton("Edit Journal");
        addButton.addActionListener(e -> {
            Distributor distributor = new Distributor();
            distributor.loadState("serial.bin");
            Journal jour = journal;

            jour.setName(nameField.getText());
            jour.setFrequency(Integer.parseInt(frequencyField.getText()));
            jour.setIssuePrice(Double.parseDouble(issuePriceField.getText()));
            distributor.saveState("serial.bin");

            dispose();
            JOptionPane.showMessageDialog(this, "Journal edited");
            new MainGUI().setVisible(true);

        });
        panel.add(addButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new MainGUI().setVisible(true);
        });
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
