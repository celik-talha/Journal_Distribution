package gui;
import code.Distributor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame implements Runnable{
    public MainGUI() {
        setTitle("Choose");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents();
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        panel.add(Box.createVerticalStrut(25));



        JButton addSubscriberButton = new JButton("Add Subscriber");
        addSubscriberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdddSubscriberGUI().setVisible(true);
            }
        });
        panel.add(addSubscriberButton);

        JButton editSubscriberButton = new JButton("Edit Subscriber");
        editSubscriberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EditSubscriberGUI().setVisible(true);
            }
        });
        panel.add(editSubscriberButton);

        JButton deleteSubscriberButton = new JButton("Delete Subscriber");
        deleteSubscriberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DeleteSubscriberGUI().setVisible(true);
            }
        });
        panel.add(deleteSubscriberButton);

        JButton searchSubscriberButton = new JButton("Search Subscriber");
        searchSubscriberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SearchSubscriberGUI().setVisible(true);
            }
        });
        panel.add(searchSubscriberButton);

        JButton showAllSubscriberButton = new JButton("Show All Subscriber");
        showAllSubscriberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ShowAllSubscriberGUI().setVisible(true);
            }
        });
        panel.add(showAllSubscriberButton);




        panel.add(Box.createVerticalStrut(25));




        JButton addJournalButton = new JButton("Add Journal");
        addJournalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddJournalGUI().setVisible(true);
            }
        });
        panel.add(addJournalButton);

        JButton editJournalButton = new JButton("Edit Journal");
        editJournalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EditJournalGUI().setVisible(true);
            }
        });
        panel.add(editJournalButton);

        JButton deleteJournalButton = new JButton("Delete Journal");
        deleteJournalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DeleteJournalGUI().setVisible(true);
            }
        });
        panel.add(deleteJournalButton);

        JButton searchJournalButton = new JButton("Search Journal");
        searchJournalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SearchJournalGUI().setVisible(true);
            }
        });
        panel.add(searchJournalButton);

        JButton showAllJournalButton = new JButton("Show All Journal");
        showAllJournalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ShowAllJournalGUI().setVisible(true);
            }
        });
        panel.add(showAllJournalButton);





        panel.add(Box.createVerticalStrut(25));






        JButton addSubscriptionButton = new JButton("Add Subscription");
        addSubscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddSubscriptionGUI().setVisible(true);
            }
        });
        panel.add(addSubscriptionButton);

        JButton listSubscriptionBySubscriberButton = new JButton("List Subscription By Subscriber");
        listSubscriptionBySubscriberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ListSubscriptionBySubscriberGUI().setVisible(true);
            }
        });
        panel.add(listSubscriptionBySubscriberButton);

        JButton listSubscriptionByJournalButton = new JButton("List Subscription By Journal");
        listSubscriptionByJournalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ListSubscriptionByJournalGUI().setVisible(true);
            }
        });
        panel.add(listSubscriptionByJournalButton);

        JButton payButton = new JButton("Pay");
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PayGUI().setVisible(true);
            }
        });
        panel.add(payButton);

        JButton listIncompletePaymentsButton = new JButton("List Incomplete Payments");
        listIncompletePaymentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Distributor distributor = new Distributor();
                distributor.loadState("serial.bin");
                JOptionPane.showMessageDialog(null, distributor.listIncompletePayments());
            }
        });
        panel.add(listIncompletePaymentsButton);

        JButton listSendingOrdersByJournalButton = new JButton("List Sending Orders By Journal");
        listSendingOrdersByJournalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ListSendingOrdersByJournalGUI().setVisible(true);
            }
        });
        panel.add(listSendingOrdersByJournalButton);

        JButton listAllSendingOrdersButton = new JButton("List All Sending Orders");
        listAllSendingOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ListAllSendingOrdersGUI().setVisible(true);
            }
        });
        panel.add(listAllSendingOrdersButton);

        panel.add(Box.createVerticalStrut(25));


        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Distributor distributor = new Distributor();
                distributor.saveState("serial.bin");
            }
        });
        panel.add(resetButton);



        add(panel);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    @Override
    public void run(){
        setVisible(true);
    }
}
