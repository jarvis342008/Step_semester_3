/**
 * Stop-Word-Filtered Word Frequency Report
 * Analyzes word frequency while excluding common stop words
 */
import java.util.*;

public class StopWordFilteredFrequency {
    
    /**
     * Prints word frequency report excluding stop words
     * @param feedback the input paragraph text
     */
    public static void printFilteredWordFrequency(String feedback) {
        // Define stop words
        Set<String> stopWords = new HashSet<>();
        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");
        
        // Normalize: convert to lowercase and remove punctuation
        String normalized = feedback.toLowerCase();
        normalized = normalized.replace(".", "").replace(",", "");
        
        // Split into words using whitespace pattern
        String[] words = normalized.split("\\s+");
        
        // Count word frequencies, skipping stop words
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            if (!stopWords.contains(word) && !word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        
        // Sort by frequency in descending order
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordFrequency.entrySet());
        sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        // Print results
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static void main(String[] args) {
        // Sample test case
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
        // Output:
        // great: 2
        // mentor: 1
        // session: 1
        // clear: 1
    }
}
