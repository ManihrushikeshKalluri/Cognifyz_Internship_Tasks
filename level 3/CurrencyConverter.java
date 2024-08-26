import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CurrencyConverter extends JFrame implements ActionListener {

    // Components
    private JTextField amountField;
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JButton convertButton;
    private JLabel resultLabel;

    // Exchange rates (dummy data for illustration)
    private HashMap<String, Double> rates;

    public CurrencyConverter() {
        // Initialize JFrame
        setTitle("Currency Converter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Initialize exchange rates
        rates = new HashMap<>();
        rates.put(" United States Dollar", 1.0); // Base currency
        rates.put("Euro", 0.85);
        rates.put("Japanese Yen", 110.0);
        rates.put("British Pound Sterling", 0.75);
        rates.put("Indian Rupee", 74.0); // Indian Rupee

        // Create UI Components
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 50, 100, 25);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(150, 50, 150, 25);
        add(amountField);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(50, 90, 100, 25);
        add(fromLabel);

        fromCurrency = new JComboBox<>(rates.keySet().toArray(new String[0]));
        fromCurrency.setBounds(150, 90, 150, 25);
        add(fromCurrency);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(50, 130, 100, 25);
        add(toLabel);

        toCurrency = new JComboBox<>(rates.keySet().toArray(new String[0]));
        toCurrency.setBounds(150, 130, 150, 25);
        add(toCurrency);

        convertButton = new JButton("Convert");
        convertButton.setBounds(150, 170, 150, 30);
        convertButton.addActionListener(this);
        add(convertButton);

        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(50, 210, 300, 25);
        add(resultLabel);

        // Show JFrame
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        // Convert button clicked
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();

            // Perform conversion
            double convertedAmount = convertCurrency(amount, from, to);

            // Display result
            resultLabel.setText("Result: " + String.format("%.2f", convertedAmount) + " " + to);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double convertCurrency(double amount, String from, String to) {
        double fromRate = rates.get(from);
        double toRate = rates.get(to);
        return (amount / fromRate) * toRate;
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
