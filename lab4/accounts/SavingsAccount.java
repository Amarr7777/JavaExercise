package lab4.accounts;

public class SavingsAccount implements Account {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("\n\n\nInsufficient funds!");
        }
    }

    public double getBalance() {
        return balance;
    }
}
