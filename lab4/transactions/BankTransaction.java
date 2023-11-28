package lab4.transactions;
import lab4.accounts.Account;
public class BankTransaction implements Transaction {
    public void execute(Account account, double amount) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("\n\n\nDeposit of $" + amount + " successful.");
        } else {
            account.withdraw(Math.abs(amount));
            System.out.println("Withdrawal of $" + Math.abs(amount) + " successful.");
        }
    }
}