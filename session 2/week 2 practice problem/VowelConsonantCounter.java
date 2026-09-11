public class VowelConsonantCounter {
    
    /**
     * Counts vowels and consonants in a given text.
     * Vowels: a, e, i, o, u (case-insensitive)
     * Consonants: all other letters (spaces are ignored)
     */
    void countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;
        
        // Convert to lowercase for case-insensitive comparison
        String lowerText = text.toLowerCase();
        
        // Loop through each character
        for (int i = 0; i < text.length(); i++) {
            char ch = lowerText.charAt(i);
            
            // Check if it's a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
            // Check if it's a consonant (letter but not a vowel, and not a space)
            else if (ch >= 'a' && ch <= 'z') {
                consonantCount++;
            }
            // Ignore spaces and other characters
        }
        
        System.out.println("Vowels: " + vowelCount + " | Consonants: " + consonantCount);
    }
    
    public static void main(String[] args) {
        VowelConsonantCounter counter = new VowelConsonantCounter();
        
        // Test case 1
        counter.countVowelsAndConsonants("Java Programming");
        
        // Test case 2
        counter.countVowelsAndConsonants("Hello World");
        
        // Test case 3
        counter.countVowelsAndConsonants("aeiou");
    }
}
