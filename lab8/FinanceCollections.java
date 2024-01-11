package lab8;
import java.util.*;

public class FinanceCollections {

    public static void main(String[] args) {
        HashSet<String> stockSymbols = new HashSet<>();
        stockSymbols.add("AAPL");
        stockSymbols.add("MSFT");
        stockSymbols.add("GOOG");
        stockSymbols.add("AMZN");

        HashMap<String, Double> stockPrices = new HashMap<>();
        stockPrices.put("AAPL", 124.56);
        stockPrices.put("MSFT", 245.67);
        stockPrices.put("GOOG", 112.34);
        stockPrices.put("AMZN", 345.78);

        LinkedHashMap<String, List<Transaction>> transactionHistories = new LinkedHashMap<>();
        transactionHistories.put("AAPL", Arrays.asList(new Transaction("Buy", 100, 123.45), new Transaction("Sell", 50, 125.67)));
        transactionHistories.put("MSFT", Arrays.asList(new Transaction("Sell", 150, 246.78), new Transaction("Buy", 75, 244.56)));
        transactionHistories.put("GOOG", Arrays.asList(new Transaction("Buy", 200, 111.23), new Transaction("Sell", 125, 110.34)));
        transactionHistories.put("AMZN", Arrays.asList(new Transaction("Buy", 300, 345.67), new Transaction("Sell", 225, 342.78)));

        System.out.println("\nStock symbols:");
        System.out.println(stockSymbols);

        System.out.println("\nStock prices:");
        System.out.println(stockPrices);

        System.out.println("\nTransaction histories:");
        for (Map.Entry<String, List<Transaction>> entry : transactionHistories.entrySet()) {
            String stockSymbol = entry.getKey();
            List<Transaction> transactions = entry.getValue();
            System.out.printf("\nStock symbol: %s\nTransactions:\n", stockSymbol);
            for (Transaction transaction : transactions) {
                System.out.printf("Type: %s, Quantity: %d, Price: %f\n", transaction.getType(), transaction.getQuantity(), transaction.getPrice());
            }
        }
    }
}

class Transaction {
    private String type; 
    private int quantity; 
    private double price; 

    public Transaction(String type, int quantity, double price) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
