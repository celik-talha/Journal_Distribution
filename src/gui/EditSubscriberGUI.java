package gui;
import code.Distributor;
import code.Corporation;
import code.Individual;
import code.Subscriber;
import javax.swing.*;
import java.awt.*;

public class EditSubscriberGUI extends JFrame{

    private JTextField nameField;
    public EditSubscriberGUI() {
        setTitle("Edit Subscriber");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents();
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        panel.add(new JLabel("Search With Name"));
        panel.add(createLabelAndTextField("Name:", nameField = new JTextField(20)));
        JButton searchButton = new JButton("Search Subscriber");
        searchButton.addActionListener(e -> {
            if(searchSubscriber(nameField.getText()) == 1){
                dispose();
                Distributor distributor = new Distributor();
                distributor.loadState("serial.bin");
                new EditFrame((Individual) distributor.searchSubscriber(nameField.getText())).setVisible(true);
            }
            else if(searchSubscriber(nameField.getText()) == 2){
                dispose();
                Distributor distributor = new Distributor();
                distributor.loadState("serial.bin");
                new EditFrame((Corporation) distributor.searchSubscriber(nameField.getText())).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "Subscriber not found");
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

    public static void main(String[] args) {
        new EditSubscriberGUI().setVisible(true);
    }
}
