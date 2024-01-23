package gui;
import javax.swing.*;
import java.awt.*;
import code.Distributor;
import code.Corporation;
import code.Individual;
import code.Subscriber;
import code.Journal;
public class DeleteJournalGUI extends JFrame{
    private JTextField issnField;
    public DeleteJournalGUI() {
        setTitle("Delete Journal");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
    }
    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Search With ISSN"));
        panel.add(createLabelAndTextField("ISSN:", issnField = new JTextField(20)));
        JButton searchButton = new JButton("Search and Delete");

        searchButton.addActionListener(e -> {
            Distributor distributor = new Distributor();
            distributor.loadState("serial.bin");

            if(distributor.deleteJournal(issnField.getText())){
                distributor.saveState("serial.bin");
                dispose();
                JOptionPane.showMessageDialog(this, "Journal deleted");
                new MainGUI().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "Journal not found");
            }

        });
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new MainGUI().setVisible(true);
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
