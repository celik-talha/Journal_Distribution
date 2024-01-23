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

public class EditJournalGUI extends JFrame{

        private JTextField issnField, nameField, frequencyField, issuePriceField;

        public EditJournalGUI() {
            setTitle("Edit Journal");
            setSize(400, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            initializeComponents();
        }

        private void initializeComponents() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            panel.add(new JLabel("Journal Information"));
            panel.add(createLabelAndTextField("ISSN:", issnField = new JTextField(20)));

            JButton addButton = new JButton("Search Journal");
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Distributor distributor = new Distributor();
                    distributor.loadState("serial.bin");
                    if(distributor.searchJournal(issnField.getText()) != null){
                        dispose();
                        new EditJournalFrame((distributor.searchJournal(issnField.getText()))).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Journal not found");
                    }
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

        private int searchJournal(String issn){
            Distributor distributor = new Distributor();
            distributor.loadState("serial.bin");
            if (distributor.searchJournal(issn) == null) {
                return 0;
            }
            else{
                return 1;
            }
        }

        private JPanel createLabelAndTextField(String labelText, JTextField textField) {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));

            panel.add(new JLabel(labelText));
            panel.add(textField);

            return panel;
        }
}
