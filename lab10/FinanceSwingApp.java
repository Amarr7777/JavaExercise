package lab10;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FinanceSwingApp {
    private JFrame frame;
    private List<Account> accountList;

    private static final String JDBC_URL = "jdbc:sqlite:finance.db";

    public FinanceSwingApp() {
        accountList = new ArrayList<>();
        initialize();
        createTable();  
        loadAccountsFromDatabase(); 
    }

    private void initialize() {
        frame = new JFrame("Finance Information");
        frame.setBounds(100, 100, 400, 400);
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

        JTextField departmentText = new JTextField(20);
        departmentText.setBounds(100, 50, 165, 25);
        panel.add(departmentText);

        JLabel accountNumberLabel = new JLabel("Account Number:");
        accountNumberLabel.setBounds(10, 80, 150, 25);
        panel.add(accountNumberLabel);

        JTextField accountNumberText = new JTextField(20);
        accountNumberText.setBounds(160, 80, 100, 25);
        panel.add(accountNumberText);

        JLabel balanceLabel = new JLabel("Balance:");
        balanceLabel.setBounds(10, 110, 80, 25);
        panel.add(balanceLabel);

        JTextField balanceText = new JTextField(20);
        balanceText.setBounds(100, 110, 165, 25);
        panel.add(balanceText);

        JButton addButton = new JButton("Add Account");
        addButton.setBounds(10, 140, 150, 25);
        panel.add(addButton);

        JButton viewButton = new JButton("View Accounts");
        viewButton.setBounds(170, 140, 150, 25);
        panel.add(viewButton);

        JButton updateButton = new JButton("Update Balance");
        updateButton.setBounds(10, 170, 150, 25);
        panel.add(updateButton);

        JButton deleteButton = new JButton("Delete Account");
        deleteButton.setBounds(170, 170, 150, 25);
        panel.add(deleteButton);

        JTextArea financeTextArea = new JTextArea();
        financeTextArea.setBounds(10, 200, 350, 120);
        panel.add(financeTextArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String accountNumber = accountNumberText.getText();
                double balance = Double.parseDouble(balanceText.getText());

                Account account = new Account(name, accountNumber, balance);
                accountList.add(account);

                insertIntoDatabase(account);

                financeTextArea.setText("");
                for (Account acc : accountList) {
                    financeTextArea.append(acc.toString() + "\n");
                }

                nameText.setText("");
                accountNumberText.setText("");
                balanceText.setText("");
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                financeTextArea.setText("");
                for (Account acc : accountList) {
                    financeTextArea.append(acc.toString() + "\n");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountNumberText.getText();
                double newBalance = Double.parseDouble(balanceText.getText());

                updateBalance(accountNumber, newBalance);

                financeTextArea.setText("");
                for (Account acc : accountList) {
                    financeTextArea.append(acc.toString() + "\n");
                }

                accountNumberText.setText("");
                balanceText.setText("");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountNumberText.getText();

                deleteAccount(accountNumber);

                financeTextArea.setText("");
                for (Account acc : accountList) {
                    financeTextArea.append(acc.toString() + "\n");
                }

                accountNumberText.setText("");
                balanceText.setText("");
            }
        });
    }

    private void createTable() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Accounts (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "account_number TEXT," +
                    "balance REAL)";
            statement.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertIntoDatabase(Account account) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO Accounts (name, account_number, balance) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(3, account.getAccountNumber());
            preparedStatement.setDouble(4, account.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadAccountsFromDatabase() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Accounts")) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String accountNumber = resultSet.getString("account_number");
                double balance = resultSet.getDouble("balance");

                Account account = new Account(name, accountNumber, balance);
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateBalance(String accountNumber, double newBalance) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE Accounts SET balance = ? WHERE account_number = ?")) {
            preparedStatement.setDouble(1, newBalance);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.executeUpdate();

            for (Account account : accountList) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    account.setBalance(newBalance);
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteAccount(String accountNumber) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM Accounts WHERE account_number = ?")) {
            preparedStatement.setString(1, accountNumber);
            preparedStatement.executeUpdate();

            accountList.removeIf(account -> account.getAccountNumber().equals(accountNumber));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new FinanceSwingApp();
        });
    }
}

class Account {
    private String name;
    private String accountNumber;
    private double balance;

    public Account(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Name: " + name + 
                ", Account Number: " + accountNumber + ", Balance: $" + balance;
    }
}
