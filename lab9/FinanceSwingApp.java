package lab9;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FinanceSwingApp {
    private JFrame frame;
    private List<Finance> financeList;

    public FinanceSwingApp() {
        financeList = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Finance Information");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JLabel balanceLabel = new JLabel("balance:");
        balanceLabel.setBounds(10, 50, 80, 25);
        panel.add(balanceLabel);

        JTextField balanceText = new JTextField(20);
        balanceText.setBounds(100, 50, 165, 25);
        panel.add(balanceText);

        JButton addButton = new JButton("Add Finance");
        addButton.setBounds(10, 80, 150, 25);
        panel.add(addButton);

        JTextArea financeTextArea = new JTextArea();
        financeTextArea.setBounds(10, 120, 350, 120);
        panel.add(financeTextArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String balance = balanceText.getText();

                Finance finance = new Finance(name, balance);
                financeList.add(finance);

                // Display finance information
                financeTextArea.setText("");
                for (Finance f : financeList) {
                    financeTextArea.append(f.toString() + "\n");
                }

                // Clear input fields
                nameText.setText("");
                balanceText.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FinanceSwingApp();
        });
    }
}

class Finance {
    private String name;
    private String balance;

    public Finance(String name, String balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getbalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Balance: " + balance;
    }
}
