import java.util.*;

public class Main {

    // Function to find the maximum profit
    public static int maxProfit(int price[]) {
        // Initialize buyPrice as the maximum possible value
        int buyPrice = Integer.MAX_VALUE;

        // Initialize maxProfit to store the maximum profit found so far
        int maxProfit = 0;

        // Loop through the price array
        for (int i = 0; i < price.length; i++) {
            
            // If current price is greater than the buyPrice, calculate profit
            if (buyPrice < price[i]) {
                int profit = price[i] - buyPrice;
                
                // Update maxProfit if current profit is greater than previous maxProfit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // If current price is lower than buyPrice, update buyPrice
                buyPrice = price[i];
            }
        }

        // Return the maximum profit
        return maxProfit;
    }

    public static void main(String args[]) {
        // Example stock prices for each day
        int price[] = {7, 1, 5, 3, 6, 4};

        // Calculate and print the maximum profit
        System.out.println("Max Profit = " + maxProfit(price));
    }
}
