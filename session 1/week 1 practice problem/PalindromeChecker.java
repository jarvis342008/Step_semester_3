import java.util.Scanner;

public class PalindromeChecker {

    /**
     * Iterative approach: compare characters from both ends moving toward the middle
     */
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
    
    /**
     * Recursive approach: compare first and last characters, shrinking the substring
     */
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
    
    /**
     * Array reversal approach: convert to array, reverse, and compare
     */
    public static boolean isPalindromeArrayReversal(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] chars = cleaned.toCharArray();
        char[] reversed = new char[chars.length];
        
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        
        return java.util.Arrays.equals(chars, reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
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
        System.out.println("\nIterative: " + iterativeResult);
        System.out.println("Recursive: " + recursiveResult);
        System.out.println("Array Reversal: " + arrayReversalResult);
        
        // Verify all three approaches agree
        if (iterative == recursive && recursive == arrayReversal) {
            System.out.println("\n✓ All three approaches agree!");
        } else {
            System.out.println("\n✗ Approaches disagree - there may be an error!");
        }
        
        scanner.close();
    }
}
