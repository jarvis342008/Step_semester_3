/**
 * Word Reversal Encoder
 * Reverses each word in a sentence individually while keeping word order the same
 */
public class WordReversalEncoder {
    
    /**
     * Reverses each word in the sentence individually
     * @param sentence the input sentence with words separated by single spaces
     * @return the sentence with each word reversed
     */
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            StringBuilder reversed = new StringBuilder(words[i]);
            result.append(reversed.reverse());
            
            // Add space after each word except the last one
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // Sample test case
        String input = "hello club";
        String output = reverseEachWord(input);
        System.out.println(output);  // Output: olleh bulc
    }
}
