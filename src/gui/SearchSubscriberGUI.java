package gui;
import javax.swing.*;
import java.awt.*;
import code.Distributor;
import code.Corporation;
import code.Individual;
import code.Subscriber;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SearchSubscriberGUI extends JFrame{
    private JTextField nameField;
    public SearchSubscriberGUI() {
        setTitle("Search Subscriber");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents();
    }

    private void initializeComponents(){
    JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Search With Name"));
        panel.add(createLabelAndTextField("Name:", nameField = new JTextField(20)));
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Distributor distributor = new Distributor();
                distributor.loadState("serial.bin");

                if(distributor.searchSubscriber(nameField.getText()) instanceof Individual){
                    JOptionPane.showMessageDialog(null, distributor.searchSubscriber(nameField.getText()).getBillingInformation());
                }
                else if(distributor.searchSubscriber(nameField.getText()) instanceof Corporation){
                    JOptionPane.showMessageDialog(null, distributor.searchSubscriber(nameField.getText()).getBillingInformation());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Subscriber not found");
                }
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

    private int searchSubscriber(String name){
        Distributor distributor = new Distributor();
        distributor.loadState("serial.bin");
        if (distributor.searchSubscriber(name) == null) {
            return 0;
        }
        else if (distributor.searchSubscriber(name) instanceof  Individual){
            return 1;
        }
        else if (distributor.searchSubscriber(name) instanceof Corporation){
            return 2;
        }
        return 0;
    }

    private JPanel createLabelAndTextField(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel.add(new JLabel(labelText));
        panel.add(textField);
        return panel;
    }
}
