public class TypingAccuracyChecker {
    public void checkTypingAccuracy(String original, String typed) {
        // Ensure both strings are the same length
        if (original.length() != typed.length()) {
            System.out.println("Error: Strings must be of equal length.");
            return;
        }
        
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;
        
        // Compare each character at the same position
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                // Record the position of the first mismatch (1-indexed for user display)
                firstMismatchPosition = i + 1;
            }
        }
        
        double accuracy = (double) matchedCharacters / original.length() * 100;
        
        System.out.print("Matched: " + matchedCharacters + "/" + original.length());
        System.out.printf(" | Accuracy: %.2f%%", accuracy);
        
        if (firstMismatchPosition == -1) {
            System.out.println(" | No Mismatches");
        } else {
            int zeroIndexedPosition = firstMismatchPosition - 1;
            System.out.println(" | First Mismatch at position " + firstMismatchPosition + 
                             " ('" + original.charAt(zeroIndexedPosition) + 
                             "' vs '" + typed.charAt(zeroIndexedPosition) + "')");
        }
    }
    public static void main(String[] args) {
        TypingAccuracyChecker checker = new TypingAccuracyChecker();
        
        
        System.out.println("Test Case 1:");
        String original1 = "hello world";
        String typed1 = "hello worlt";
        checker.checkTypingAccuracy(original1, typed1);
        
        System.out.println("\nTest Case 2:");
    
        String original2 = "coding";
        String typed2 = "coding";
        checker.checkTypingAccuracy(original2, typed2);
    }
}
