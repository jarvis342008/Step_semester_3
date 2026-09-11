/**
 * Problem 2: Duplicate Player Pick Checker
 * Topics: Arrays, Strings, Nested Loops
 * 
 * Check a submitted lineup for repeated player names before acceptance.
 * Uses plain nested loops with no Collections class.
 */
public class Problem2_DuplicatePlayerPickChecker {
    
    /**
     * Finds the first duplicate player name using nested loops.
     * 
     * @param playerNames Array of player names
     * @return Message indicating the first duplicate found, or "No Duplicates Found"
     */
    static String findDuplicatePick(String[] playerNames) {
        // Compare each name against every name that comes after it
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }
    
    public static void main(String[] args) {
        // Example 1: Duplicate exists
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("Example 1: " + findDuplicatePick(lineup1));
        // Expected: Duplicate Found: Kohli
        
        // Example 2: No duplicates
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println("Example 2: " + findDuplicatePick(lineup2));
        // Expected: No Duplicates Found
        
        // Example 3: Multiple duplicates (should return first)
        String[] lineup3 = {"Virat", "Bumrah", "Virat", "Rohit", "Bumrah"};
        System.out.println("Example 3: " + findDuplicatePick(lineup3));
        // Expected: Duplicate Found: Virat (first duplicate in order)
    }
}
