import java.util.Arrays;

/**
 * Problem 5: Fantasy League Auto-Draft Ranking Engine
 * Topics: Arrays, Method Overloading, Static Methods, Standard Library (Arrays.sort),
 *         Constructors & Encapsulation, Comparable Interface
 * 
 * Auto-draft feature that decides which players are draftable and ranks them by fantasy points.
 * Players with long track record qualify on experience alone, newer players need fitness+experience.
 */
public class Problem5_FantasyLeagueAutoDraftRankingEngine {
    
    /**
     * Player class implementing Comparable for automatic ranking by fantasy points (descending).
     */
    static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;
        
        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }
        
        public String getName() {
            return name;
        }
        
        public int getMatchesPlayed() {
            return matchesPlayed;
        }
        
        public double getBattingAverage() {
            return battingAverage;
        }
        
        public boolean isInjured() {
            return injured;
        }
        
        /**
         * Calculates fantasy points based on matches played and batting average.
         */
        public double getFantasyPoints() {
            return matchesPlayed * battingAverage;
        }
        
        /**
         * Compares players by fantasy points in descending order.
         * Higher fantasy points come first.
         */
        @Override
        public int compareTo(Player other) {
            // Descending order: if this.points > other.points, return -1
            double thisPoints = this.getFantasyPoints();
            double otherPoints = other.getFantasyPoints();
            
            if (thisPoints > otherPoints) return -1;
            if (thisPoints < otherPoints) return 1;
            return 0;
        }
        
        @Override
        public String toString() {
            return name;
        }
    }
    
    /**
     * Check if a player is draftable based on experience alone.
     * Threshold: at least 10 matches played.
     */
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }
    
    /**
     * Check if a player is draftable based on experience and fitness.
     * Threshold: at least 5 matches played AND not injured.
     */
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }
    
    /**
     * Filters draftable players and ranks them by fantasy points (descending).
     */
    static String draftAndRank(Player[] players) {
        // Filter draftable players
        Player[] draftablePlayers = new Player[players.length];
        int count = 0;
        
        for (Player player : players) {
            // Check if player qualifies under either rule:
            // Rule 1: Experience only (10+ matches)
            // Rule 2: Experience AND fitness (5+ matches and not injured)
            if (isDraftable(player.getMatchesPlayed()) || 
                isDraftable(player.getMatchesPlayed(), player.isInjured())) {
                draftablePlayers[count++] = player;
            }
        }
        
        // Create array of only draftable players
        Player[] finalDraftable = new Player[count];
        System.arraycopy(draftablePlayers, 0, finalDraftable, 0, count);
        
        // Sort by fantasy points (descending) using Comparable
        Arrays.sort(finalDraftable);
        
        // Build result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < finalDraftable.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(finalDraftable[i].getName());
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // Example 1
        Player[] players1 = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println("Example 1: " + draftAndRank(players1));
        // Expected: 1. Rahul | 2. Virat | 3. Dev
        
        // Example 2
        Player[] players2 = {
            new Player("Rohit", 20, 50.0, false),
            new Player("Bumrah", 18, 30.0, true),
            new Player("Shikhar", 8, 45.0, false),
            new Player("Hardik", 4, 40.0, true)
        };
        System.out.println("Example 2: " + draftAndRank(players2));
        // Expected: 1. Rohit | 2. Shikhar | 3. Bumrah
        
        // Example 3
        Player[] players3 = {
            new Player("Kane", 25, 55.0, false),
            new Player("Bairstow", 9, 50.0, false),
            new Player("Root", 10, 45.0, true),
            new Player("Stokes", 12, 42.0, false)
        };
        System.out.println("Example 3: " + draftAndRank(players3));
        // Expected: 1. Kane | 2. Stokes | 3. Root | 4. Bairstow
    }
}
