package gui;
import javax.swing.*;
import java.awt.*;
import code.Distributor;
import code.Corporation;
import code.Individual;
import code.Subscriber;
import code.Journal;

public class SearchJournalGUI extends JFrame{
        private JTextField issnField;
        public SearchJournalGUI() {
            setTitle("Search Journal");
            setSize(400, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            initializeComponents();
        }

        private void initializeComponents() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            panel.add(new JLabel("Search With ISSN"));
            panel.add(createLabelAndTextField("ISSN:", issnField = new JTextField(20)));
            JButton searchButton = new JButton("Search Journal");

            searchButton.addActionListener(e -> {
                Distributor distributor = new Distributor();
                distributor.loadState("serial.bin");

                if(distributor.searchJournal(issnField.getText()) != null){
                    //print journal information as a message
                    String infoMessage = "Name: " +  distributor.searchJournal(issnField.getText()).getName() +
                            "\nISSN:  " + distributor.searchJournal(issnField.getText()).getIssn() +
                            "\nFrequency: " + distributor.searchJournal(issnField.getText()).getFrequency() +
                            "\nIssue Price: " + distributor.searchJournal(issnField.getText()).getIssuePrice() ;
                    dispose();
                    JOptionPane.showMessageDialog(null, infoMessage);
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
