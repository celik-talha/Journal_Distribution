package gui;
import code.Distributor;
import code.Corporation;
import code.Individual;
import code.Subscriber;
import javax.swing.*;
import java.awt.*;

public class ShowAllSubscriberGUI extends JFrame{

        public ShowAllSubscriberGUI() {
            setTitle("Show All Subscriber");
            setSize(400, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            initializeComponents();
        }

        private void initializeComponents() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            Distributor distributor = new Distributor();
            distributor.loadState("serial.bin");
            for (Subscriber subscriber : distributor.getSubscribers()) {
                if (subscriber instanceof Individual) {
                    panel.add(new JLabel("Individual Subscriber"));
                    panel.add(new JLabel("Name: " + subscriber.getName()));
                    panel.add(new JLabel("Address: " + subscriber.getAddress()));
                    panel.add(new JLabel("Credit Card Number: " + ((Individual) subscriber).getCreditCardNr()));
                    panel.add(new JLabel("Expire Month: " + ((Individual) subscriber).getExpireMonth()));
                    panel.add(new JLabel("Expire Year: " + ((Individual) subscriber).getExpireYear()));
                    panel.add(new JLabel("CCV: " + ((Individual) subscriber).getCCV()));
                    panel.add(new JLabel("----------------"));
                } else if (subscriber instanceof Corporation) {
                    panel.add(new JLabel("Corporation Subscriber"));
                    panel.add(new JLabel("Name: " + subscriber.getName()));
                    panel.add(new JLabel("Address: " + subscriber.getAddress()));
                    panel.add(new JLabel("Bank Code: " + ((Corporation) subscriber).getBankCode()));
                    panel.add(new JLabel("Bank Name: " + ((Corporation) subscriber).getBankName()));
                    panel.add(new JLabel("Issue Day: " + ((Corporation) subscriber).getIssueDay()));
                    panel.add(new JLabel("Issue Month: " + ((Corporation) subscriber).getIssueMonth()));
                    panel.add(new JLabel("Issue Year: " + ((Corporation) subscriber).getIssueYear()));
                    panel.add(new JLabel("Account Number: " + ((Corporation) subscriber).getAccountNumber()));
                    panel.add(new JLabel("----------------"));
                }
            }

            JButton backButton = new JButton("Back");
            backButton.addActionListener(e -> {
                dispose();
                new MainGUI().setVisible(true);
            });
            panel.add(backButton);



            add(panel);
            add(new JScrollPane(panel));
        }
}