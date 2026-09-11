import java.util.Arrays;

/**
 * Problem 1: Fantasy Team Score Multiplier
 * Topics: Creating/Modifying Arrays, Arrays Passed by Reference
 * 
 * Write a method that applies both multipliers directly to the lineup's score array.
 * Captain gets 2× points, Vice-Captain gets 1.5× points.
 */
public class Problem1_FantasyTeamScoreMultiplier {
    
    /**
     * Applies captain (2×) and vice-captain (1.5×) multipliers directly to the array.
     * 
     * @param playerScores The array of player scores to modify
     * @param captainIndex Index of the captain
     * @param viceCaptainIndex Index of the vice-captain
     */
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }
    
    public static void main(String[] args) {
        // Example 1
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println("Example 1: " + Arrays.toString(scores));
        // Expected: [40.0, 110.0, 30.0, 93.0]
        
        // Example 2
        double[] scores2 = {25.5, 45.0, 60.0, 35.5, 50.0};
        applyMultipliers(scores2, 0, 2);
        System.out.println("Example 2: " + Arrays.toString(scores2));
        // Expected: [51.0, 45.0, 90.0, 35.5, 50.0]
    }
}
