public class BankAccount {

    public static void main(String[] args) {
        System.out.println("\nAccount Details");
        SavingsAccount savingsAccount = new SavingsAccount("SA-123", 0.05);
        double savingsInterest = savingsAccount.calculateInterest(1000);
        System.out.println("\nInterest earned from Savings Account: " + savingsInterest);

        FixedDeposit fixedDeposit = new FixedDeposit("FD-456", 0.08, 5);
        double fdInterest = fixedDeposit.calculateInterest(5000);
        System.out.println("Interest earned from Fixed Deposit: " + fdInterest);

        fixedDeposit.displayMaturityAmount(5000);
    }
}

abstract class FinancialProduct {
    protected String productId;
    protected double interestRate;

    public FinancialProduct(String productId, double interestRate) {
        this.productId = productId;
        this.interestRate = interestRate;
    }

    public abstract double calculateInterest(double principal);
}

class SavingsAccount extends FinancialProduct {
    public SavingsAccount(String productId, double interestRate) {
        super(productId, interestRate);
    }

    @Override
    public double calculateInterest(double principal) {
        return principal * interestRate;
    }
}

final class FixedDeposit extends FinancialProduct {
    private int tenure;

    public FixedDeposit(String productId, double interestRate, int tenure) {
        super(productId, interestRate);
        this.tenure = tenure;
    }

    @Override
    public double calculateInterest(double principal) {
        return principal * interestRate * tenure;
    }

    public final void displayMaturityAmount(double principal) {
        double maturityAmount = principal + calculateInterest(principal);
        System.out.println("Maturity Amount for " + productId + ": " + maturityAmount+"\n");
    }
}
