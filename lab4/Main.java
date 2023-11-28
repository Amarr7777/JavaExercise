package lab4;
import lab4.accounts.*;
import lab4.transactions.*;

public class Main {
    public static void main(String[] args) {

        Account savings = new SavingsAccount();
        Account checking = new CheckingAccount();

        Transaction transaction = new BankTransaction();

        transaction.execute(savings, 100); 
        transaction.execute(checking, -50); 

        System.out.println("\n\n\nSavings Account Balance: $" + savings.getBalance());
        System.out.println("Checking Account Balance: $" + checking.getBalance());
    }
}

