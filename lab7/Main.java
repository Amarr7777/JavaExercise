package lab7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("TATAMOTORS", 150.25, 1000));
        stocks.add(new Stock("COCHINSHIPYARD", 2800.50, 500));
        stocks.add(new Stock("ITC", 350.75, 750));

        Stock highestPricedStock = StockPortfolioAnalyzer.findHighestPricedStock(stocks);
        System.out.println("Highest-priced stock: " + highestPricedStock.getTicker());

        StockPortfolioAnalyzer.sortStocksByVolume(stocks);
        System.out.println("Stocks sorted by volume: ");
        for (Stock stock : stocks) {
            System.out.println(stock.getTicker() + " - Volume: " + stock.getVolume());
        }

        double totalValue = StockPortfolioAnalyzer.calculateTotalPortfolioValue(stocks);
        System.out.println("Total portfolio value: " + totalValue);
    }
}
class Stock {
    private String ticker;
    private double price;
    private int volume;

    public Stock(String ticker, double price, int volume) {
        this.ticker = ticker;
        this.price = price;
        this.volume = volume;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }
}

class StockPortfolioAnalyzer {
    public static Stock findHighestPricedStock(List<Stock> stocks) {
        return stocks.stream()
                .max(Comparator.comparingDouble(Stock::getPrice))
                .orElse(null);
    }

    public static void sortStocksByVolume(List<Stock> stocks) {
        stocks.sort(Comparator.comparingInt(Stock::getVolume));
    }

    public static double calculateTotalPortfolioValue(List<Stock> stocks) {
        return stocks.stream()
                .mapToDouble(stock -> stock.getPrice() * stock.getVolume())
                .sum();
    }
}


