package gui;
import code.Distributor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ReportGUI extends JFrame implements Runnable{
    public ReportGUI() {
        setTitle("Report");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents();
    }


    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(25));

        JButton expiredSubscriptionsButton = new JButton("Expired Subscriptions");
        expiredSubscriptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ExpiredSubscriptionGUI().setVisible(true);
            }
        });
        panel.add(expiredSubscriptionsButton);

        JButton annualPaymentsButton = new JButton("Annual Payments");
        annualPaymentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AnnualPaymentsGUI().setVisible(true);
            }
        });
        panel.add(annualPaymentsButton);

        add(panel);
    }

    @Override
    public void run() {
        initializeComponents();
    }
}
