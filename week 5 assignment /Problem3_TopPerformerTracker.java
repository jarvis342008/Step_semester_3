/**
 * Problem 3: Top Performer Tracker
 * Topics: Arrays, Loops, Logical Thinking
 * 
 * Find the minimum and maximum scores in a single pass without sorting,
 * and report the spread (max - min).
 */
public class Problem3_TopPerformerTracker {
    
    /**
     * Finds the minimum, maximum, and spread in a single pass.
     * 
     * @param scores Array of player scores
     * @return String with format "Min: X | Max: Y | Spread: Z"
     */
    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];
        
        // Single pass through the array
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        
        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }
    
    public static void main(String[] args) {
        // Example 1
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Example 1: " + findMinMaxSpread(scores1));
        // Expected: Min: 33 | Max: 90 | Spread: 57
        
        // Example 2
        int[] scores2 = {10, 20, 15, 5, 25};
        System.out.println("Example 2: " + findMinMaxSpread(scores2));
        // Expected: Min: 5 | Max: 25 | Spread: 20
        
        // Example 3
        int[] scores3 = {100, 50};
        System.out.println("Example 3: " + findMinMaxSpread(scores3));
        // Expected: Min: 50 | Max: 100 | Spread: 50
    }
}
