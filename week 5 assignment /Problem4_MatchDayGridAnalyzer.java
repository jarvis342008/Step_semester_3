/**
 * Problem 4: Match Day Grid Analyzer
 * Topics: 2D Arrays, User-Defined Methods (reused), Loops
 * 
 * Classify cricket matches as "Power Surge" (high scoring rate) or "Normal"
 * using a private helper method to compute row averages.
 */
public class Problem4_MatchDayGridAnalyzer {
    
    /**
     * Private helper method to compute the average of a single row.
     * 
     * @param row Array of runs scored in each over
     * @return Average runs per over
     */
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0.0;
        
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }
    
    /**
     * Classifies each match as "Power Surge" or "Normal" based on average.
     * 
     * @param runsPerOver 2D array where each row is one match
     * @param threshold Minimum average to qualify as "Power Surge"
     * @return String with classification for each match
     */
    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);
            String classification = average >= threshold ? "Power Surge" : "Normal";
            
            if (i > 0) {
                result.append(" | ");
            }
            result.append("Match ").append(i).append(": ").append(classification);
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // Example 1
        int[][] runsPerOver1 = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println("Example 1: " + classifyMatches(runsPerOver1, 8));
        // Expected: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
        
        // Example 2
        int[][] runsPerOver2 = {
            {5, 5, 5},
            {20, 20},
            {8, 8, 8, 8}
        };
        System.out.println("Example 2: " + classifyMatches(runsPerOver2, 10));
        // Expected: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
        
        // Example 3
        int[][] runsPerOver3 = {
            {15, 15, 15},
            {12, 13, 14}
        };
        System.out.println("Example 3: " + classifyMatches(runsPerOver3, 10));
        // Expected: Match 0: Power Surge | Match 1: Power Surge
    }
}
