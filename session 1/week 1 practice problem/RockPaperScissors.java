import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static Scanner scanner = new Scanner(System.in);

    // ==================== PROBLEM 1: ROCK-PAPER-SCISSORS ====================

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        playerMove = playerMove.toLowerCase();
        computerMove = computerMove.toLowerCase();
        
        if (playerMove.equals("rock") && computerMove.equals("scissors")) {
            return "Player Wins";
        } else if (playerMove.equals("paper") && computerMove.equals("rock")) {
            return "Player Wins";
        } else if (playerMove.equals("scissors") && computerMove.equals("paper")) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }
    
    public static String getComputerMove() {
        Random random = new Random();
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            case 2:
                return "Scissors";
            default:
                return "Rock";
        }
    }

    public static void runRockPaperScissors() {
        final int NUM_ROUNDS = 5;
        
        String[] playerMoves = new String[NUM_ROUNDS];
        String[] computerMoves = new String[NUM_ROUNDS];
        String[] results = new String[NUM_ROUNDS];
        
        int wins = 0;
        int losses = 0;
        int draws = 0;
        
        System.out.println("========== Rock-Paper-Scissors Game ==========\n");
        
        for (int i = 0; i < NUM_ROUNDS; i++) {
            System.out.print("Round " + (i + 1) + " - Enter your move (Rock/Paper/Scissors): ");
            String playerMove = scanner.nextLine();
            
            if (!playerMove.equalsIgnoreCase("rock") && 
                !playerMove.equalsIgnoreCase("paper") && 
                !playerMove.equalsIgnoreCase("scissors")) {
                System.out.println("Invalid move! Please enter Rock, Paper, or Scissors.");
                i--;
                continue;
            }
            
            String computerMove = getComputerMove();
            String result = playRound(playerMove, computerMove);
            
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;
            
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            
            System.out.println("Player: " + playerMove + " | Computer: " + computerMove + " | " + result);
            System.out.println();
        }
        
        System.out.println("\n========== Summary Table ==========");
        System.out.println(String.format("%-10s %-15s %-15s %-15s", "Round", "Player Move", "Computer Move", "Result"));
        System.out.println("-----------------------------------------------");
        
        for (int i = 0; i < NUM_ROUNDS; i++) {
            System.out.println(String.format("%-10d %-15s %-15s %-15s", 
                i + 1, playerMoves[i], computerMoves[i], results[i]));
        }
        
        double winPercentage = (double) wins / NUM_ROUNDS * 100;
        System.out.println("\n========== Final Scoreboard ==========");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + 
                         " | Win % = " + String.format("%.1f", winPercentage) + "%\n");
    }

    // ==================== PROBLEM 2: PALINDROME CHECKER ====================

    public static boolean isPalindromeIterative(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static boolean isPalindromeRecursive(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindromeRecursiveHelper(cleaned, 0, cleaned.length() - 1);
    }
    
    private static boolean isPalindromeRecursiveHelper(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        
        return isPalindromeRecursiveHelper(text, left + 1, right - 1);
    }
    
    public static boolean isPalindromeArrayReversal(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] chars = cleaned.toCharArray();
        char[] reversed = new char[chars.length];
        
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        
        return java.util.Arrays.equals(chars, reversed);
    }

    public static void runPalindromeChecker() {
        System.out.println("========== Palindrome Checker (3 Approaches) ==========\n");
        System.out.print("Enter a text to check if it's a palindrome: ");
        String input = scanner.nextLine();
        
        boolean iterative = isPalindromeIterative(input);
        boolean recursive = isPalindromeRecursive(input);
        boolean arrayReversal = isPalindromeArrayReversal(input);
        
        String iterativeResult = iterative ? "Palindrome" : "Not Palindrome";
        String recursiveResult = recursive ? "Palindrome" : "Not Palindrome";
        String arrayReversalResult = arrayReversal ? "Palindrome" : "Not Palindrome";
        
        System.out.println("\n========== Results ==========");
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Iterative: " + iterativeResult);
        System.out.println("Recursive: " + recursiveResult);
        System.out.println("Array Reversal: " + arrayReversalResult);
        
        if (iterative == recursive && recursive == arrayReversal) {
            System.out.println("\n✓ All three approaches agree!\n");
        } else {
            System.out.println("\n✗ Approaches disagree - there may be an error!\n");
        }
    }

    // ==================== PROBLEM 3: BMI CALCULATOR ====================

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    
    public static double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }
    
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("\n========== Corporate Wellness Report ==========\n");
        System.out.println(String.format("%-10s %-15s %-15s %-15s %-15s", 
            "Person", "Height (m)", "Weight (kg)", "BMI", "Status"));
        System.out.println("--------------------------------------------------------------------------");
        
        for (int i = 0; i < heights.length; i++) {
            double bmi = calculateBMI(heights[i], weights[i]);
            String status = getBmiStatus(bmi);
            System.out.println(String.format("%-10d %-15.2f %-15.2f %-15.2f %-15s", 
                i + 1, heights[i], weights[i], bmi, status));
        }
        System.out.println();
    }

    public static void runBMICalculator() {
        final int TEAM_SIZE = 10;
        double[] heights = new double[TEAM_SIZE];
        double[] weights = new double[TEAM_SIZE];
        
        Random random = new Random();
        
        System.out.println("========== Generating Employee Data ==========\n");
        
        for (int i = 0; i < TEAM_SIZE; i++) {
            heights[i] = 1.50 + (random.nextDouble() * 0.50);
            weights[i] = 45 + (random.nextDouble() * 75);
            
            System.out.println("Person " + (i + 1) + " - Height: " + 
                String.format("%.2f", heights[i]) + " m, Weight: " + 
                String.format("%.2f", weights[i]) + " kg");
        }
        
        printWellnessReport(heights, weights);
    }

    // ==================== PROBLEM 4: FIRST NON-REPEATING CHAR ====================

    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        
        for (char c : text.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        
        for (char c : text.toCharArray()) {
            if (charFrequency.get(c) == 1) {
                return c;
            }
        }
        
        return '\0';
    }

    public static void runFirstNonRepeatingChar() {
        System.out.println("========== Unique Letter Hunt Mini-Game ==========\n");
        System.out.print("Enter a word or sentence: ");
        String input = scanner.nextLine();
        
        char result = findFirstNonRepeatingChar(input);
        
        System.out.println("\n========== Result ==========");
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
        
        System.out.println("\n========== Character Frequency ==========");
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : input.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        
        charFrequency.forEach((character, count) -> 
            System.out.println("'" + character + "': " + count)
        );
        System.out.println();
    }

    // ==================== PROBLEM 5: REVERSE CUSTOMER NAME ====================

    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(chars);
    }

    public static void runReverseCustomerName() {
        System.out.println("========== Customer Identity Verification System ==========\n");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        
        String reversedName = reverseCustomerName(customerName);
        
        System.out.println("\n========== Verification Result ==========");
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
        System.out.println();
    }

    // ==================== MAIN MENU ====================

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========== Week 1 Practice Problems Menu ==========");
            System.out.println("1. Rock-Paper-Scissors Game");
            System.out.println("2. Palindrome Checker (3 Approaches)");
            System.out.println("3. BMI Calculator for a Team");
            System.out.println("4. First Non-Repeating Character");
            System.out.println("5. Reverse Customer Name");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice (0-5): ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    runRockPaperScissors();
                    break;
                case "2":
                    runPalindromeChecker();
                    break;
                case "3":
                    runBMICalculator();
                    break;
                case "4":
                    runFirstNonRepeatingChar();
                    break;
                case "5":
                    runReverseCustomerName();
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter 0-5.\n");
            }
        }
    }
}
