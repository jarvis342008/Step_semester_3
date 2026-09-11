public class WordLengthProfiler {
    
    /**
     * Classifies words in a movie review by their length.
     * Categorizes words as Short (1-4 letters), Medium (5-8 letters), or Long (9+ letters).
     * 
     * @param review a string containing the movie review
     */
    public void classifyWordLengths(String review) {
        // Handle empty or null review
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Error: Review cannot be empty.");
            return;
        }
        
        // Split the review into individual words
        String[] words = review.split("\\s+");
        
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;
        
        // Classify each word by its length
        for (String word : words) {
            // Remove punctuation for accurate length calculation
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            
            // Skip empty strings after removing punctuation
            if (cleanWord.isEmpty()) {
                continue;
            }
            
            int length = cleanWord.length();
            
            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }
        
        // Print the word length classification results
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }
    
    /**
     * Main method to test the word length profiler with sample inputs
     */
    public static void main(String[] args) {
        WordLengthProfiler profiler = new WordLengthProfiler();
        
        // Test case 1: Sample from assignment
        System.out.println("Test Case 1:");
        String review1 = "This movie was absolutely fantastic and thrilling";
        profiler.classifyWordLengths(review1);
        
        System.out.println("\nTest Case 2:");
        // Test case 2: Review with more variety
        String review2 = "Great film! I loved it so much.";
        profiler.classifyWordLengths(review2);
        
        System.out.println("\nTest Case 3:");
        // Test case 3: Review with punctuation
        String review3 = "Amazing, wonderful, extraordinary experience!";
        profiler.classifyWordLengths(review3);
        
        System.out.println("\nTest Case 4:");
        // Test case 4: All short words
        String review4 = "I go to see it all";
        profiler.classifyWordLengths(review4);
        
        System.out.println("\nTest Case 5:");
        // Test case 5: All long words
        String review5 = "Magnificent masterpiece unforgettable incredible";
        profiler.classifyWordLengths(review5);
    }
}
