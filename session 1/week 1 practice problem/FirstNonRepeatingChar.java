import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingChar {

    /**
     * Finds the first non-repeating character in a string
     */
    public static char findFirstNonRepeatingChar(String text) {
        // Create a frequency map of all characters
        Map<Character, Integer> charFrequency = new HashMap<>();
        
        for (char c : text.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        
        // Scan left to right and find the first character with frequency 1
        for (char c : text.toCharArray()) {
            if (charFrequency.get(c) == 1) {
                return c;
            }
        }
        
        // No non-repeating character found
        return '\0'; // null character to indicate not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
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
        
        // Show character frequencies for reference
        System.out.println("\n========== Character Frequency ==========");
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : input.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        
        charFrequency.forEach((character, count) -> 
            System.out.println("'" + character + "': " + count)
        );
        
        scanner.close();
    }
}
