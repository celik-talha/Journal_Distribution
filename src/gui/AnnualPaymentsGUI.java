package gui;
import code.*;
import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;
public class AnnualPaymentsGUI extends JFrame{
    private JTextField startYearField, endYearField;
    public AnnualPaymentsGUI() {
        setTitle("Annual Payments");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
    }
    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Search With Year"));
        panel.add(createLabelAndTextField("Start Year:", startYearField = new JTextField(20)));
        panel.add(createLabelAndTextField("End Year:", endYearField = new JTextField(20)));

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {
            Distributor distributor = new Distributor();
            distributor.loadState("serial.bin");
            String msg = "";
            Hashtable<String, Journal> journals = distributor.getJournals();
            for (Journal journal : journals.values()) {
                for (Subscription subscription : journal.getSubscriptions()) {
                    if (subscription.getDates().getStartYear() >= Integer.parseInt(startYearField.getText()) && subscription.getDates().getStartYear() <= Integer.parseInt(endYearField.getText())) {
                        msg += subscription.getSubscriber().getName() + "-" + journal.getName() + "-" + "Payment Date:" +  subscription.getDates().getStartMonth() + "/" + subscription.getDates().getStartYear() +"- Payment Amount:"+ subscription.getPayment().getReceivedPayment() + "\n";
                    }
                }
            }
            JOptionPane.showMessageDialog(this, msg);
        });
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new ReportGUI().setVisible(true);
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
