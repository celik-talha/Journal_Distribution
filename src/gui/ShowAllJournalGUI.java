package gui;
import javax.swing.*;
import java.awt.*;
import code.Distributor;
import code.Corporation;
import code.Individual;
import code.Subscriber;
import code.Journal;

public class ShowAllJournalGUI extends JFrame{
    public ShowAllJournalGUI() {
        setTitle("Show All Journal");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents();
    }

    private void initializeComponents(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        Distributor distributor = new Distributor();
        distributor.loadState("serial.bin");

        distributor.getJournals().forEach((k, v) -> {
            panel.add(new JLabel("Name:          " + v.getName()));
            panel.add(new JLabel("ISSN:            " + v.getIssn()), BorderLayout.CENTER);
            panel.add(new JLabel("Frequency:   " + String.valueOf(v.getFrequency())), BorderLayout.CENTER);
            panel.add(new JLabel("Issue Price:  " + String.valueOf(v.getIssuePrice())), BorderLayout.CENTER);
            panel.add(Box.createRigidArea(new Dimension(0, 15)));
        });

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
