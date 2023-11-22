package LABexe.lab1;

public class BankAccount {
    private int accNumber;
    private double balance;
    private char accType;

    BankAccount() {
        this.accNumber = 0;
        this.balance = 0.0;
        this.accType = 'N';
    }

    BankAccount(int accNumber, double balance, char accType) {
        this.accNumber = accNumber;
        this.balance = balance;
        this.accType = accType;
    }

    BankAccount(int accNumber, long balance, char accType) {
        this.accNumber = accNumber;
        this.balance = balance;
        this.accType = accType;
    }

    public void displayDetails() {
        System.out.println("Account Number is " + accNumber);
        System.out.println("Account Balance is " + balance);
        System.out.println("Account Type is " + accType);
    }

    public void checkBalance() {
        System.out.println("balance is " + this.balance);
    }

    public void checkBalance(int accNumber) {
        if (accNumber != this.accNumber) {
            System.out.println("invalid account number");
        } else {
            System.out.println("Balnce is " + this.balance);
        }
    }

    public static void main(String[] args) {
        System.out.println("\n\nDefault constructor");
        BankAccount account1 = new BankAccount();
        account1.displayDetails();
        System.out.println("\n\nconstructor overloading 1");
        BankAccount account2 = new BankAccount(2001220221, 899928.365, 's');
        account2.displayDetails();
        System.out.println("\n\nconstructor overloading 2");
        BankAccount account3 = new BankAccount(2001220221, 1122425435458776432456.365, 's');
        account3.displayDetails();
        System.out.println("\n\nMethod overloading");
        account2.checkBalance();
        account2.checkBalance(200122022);
    }
}

