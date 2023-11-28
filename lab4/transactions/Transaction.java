package lab4.transactions;
import lab4.accounts.Account;

// Transaction interface
public interface Transaction {
    void execute(Account account, double amount);
}

// BankTransaction class implementing Transaction interface


