package lab5;

public class Finance {
    public static void main(String[] args) {
        Account account1 = new Account("Shyam", 1000);
        Account account2 = new Account("Karan", 500);

        Transaction transaction1 = new Transaction(account1, true, 200);
        Transaction transaction2 = new Transaction(account2, false, 100);
        Transaction transaction3 = new Transaction(account1, false, 150);

        Thread thread1 = new Thread(transaction1);
        Thread thread2 = new Thread(transaction2);
        Thread thread3 = new Thread(transaction3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Balances:");
        System.out.println(account1.getAccountHolder() + ": $" + account1.getBalance());
        System.out.println(account2.getAccountHolder() + ": $" + account2.getBalance());
    }
}

class Account {
    private String accountHolder;
    private double balance;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public  void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited: $" + amount);
    }

    public  void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds for " + accountHolder + " to withdraw $" + amount);
        }
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }
}

class Transaction implements Runnable {
    private Account account;
    private boolean isDeposit;
    private double amount;

    public Transaction(Account account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}


