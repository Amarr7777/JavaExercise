package lab6;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        InvestmentPortfolio<Stock> stockPortfolio = new InvestmentPortfolio<>();

        Stock stock1 = new Stock(50.0, 100);
        Stock stock2 = new Stock(30.0, 75);

        stockPortfolio.addInvestment(stock1);
        stockPortfolio.addInvestment(stock2);

        double stockPortfolioValue = stockPortfolio.calculateTotalValue();
        System.out.println("Stock Portfolio Value: ₹" + stockPortfolioValue);

        // Create an investment portfolio for bonds
        InvestmentPortfolio<Bond> bondPortfolio = new InvestmentPortfolio<>();

        Bond bond1 = new Bond(1000.0, 950.0);
        Bond bond2 = new Bond(500.0, 480.0);

        bondPortfolio.addInvestment(bond1);
        bondPortfolio.addInvestment(bond2);

        double bondPortfolioValue = bondPortfolio.calculateTotalValue();
        System.out.println("Bond Portfolio Value: ₹" + bondPortfolioValue);
    }
}
 class InvestmentPortfolio<T extends Investment> {
    private List<T> investments;

    public InvestmentPortfolio() {
        investments = new ArrayList<>();
    }

    public void addInvestment(T investment) {
        investments.add(investment);
    }

    public double calculateTotalValue() {
        double totalValue = 0.0;
        for (T investment : investments) {
            totalValue += investment.getValue();
        }
        return totalValue;
    }
    public List<T> getInvestments() {
        return investments;
    }

}

 interface Investment {
    double getValue();
}

 class Stock implements Investment {
    private double pricePerShare;
    private int quantity;

    public Stock(double pricePerShare, int quantity) {
        this.pricePerShare = pricePerShare;
        this.quantity = quantity;
    }

    @Override
    public double getValue() {
        return pricePerShare * quantity;
    }
}

 class Bond implements Investment {
    private double faceValue;
    private double marketValue;

    public Bond(double faceValue, double marketValue) {
        this.faceValue = faceValue;
        this.marketValue = marketValue;
    }

    @Override
    public double getValue() {
        return marketValue;
    }
}



