/**
 * L2. Best Time to Buy and Sell Stock
 * 
 * Task: Find the single best day to buy and a later day to sell for maximum profit.
 * Walk through the array once, tracking the lowest price seen so far.
 * At each day, calculate profit (today's price - lowest price) and track the maximum.
 */
public class L2_BestTimeToBuyAndSellStock {
    
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int minPrice = prices[0];  // Track the lowest price seen so far
        int maxProfit = 0;         // Track the maximum profit found
        
        // Walk through the array once, left to right
        for (int i = 1; i < prices.length; i++) {
            // Calculate profit if we sell at today's price
            int profit = prices[i] - minPrice;
            
            // Update max profit if current profit is better
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            
            // Update minimum price if current price is lower
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        
        return maxProfit;
    }
    
    // Test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        int result1 = maxProfit(prices1);
        System.out.println("Input: prices = [7, 1, 5, 3, 6, 4]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 5 (buy on day 2 at price 1, sell on day 5 at price 6)\n");
        
        // Test case 2
        int[] prices2 = { 7, 6, 4, 3, 1 };
        int result2 = maxProfit(prices2);
        System.out.println("Input: prices = [7, 6, 4, 3, 1]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 0 (prices only fall, so no trade is profitable)");
    }
}
