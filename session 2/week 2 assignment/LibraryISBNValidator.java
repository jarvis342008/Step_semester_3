/**
 * Library ISBN Normalizer & Validator
 * Normalizes and validates ISBN-style codes
 * Valid format: 13 characters total - 3 letters (publisher) + 4 digits (year) + 6 digits (catalog)
 */
public class LibraryISBNValidator {
    
    /**
     * Normalizes a raw ISBN code by trimming spaces and uppercasing the publisher code
     * @param raw the raw ISBN string
     * @return the normalized ISBN code
     */
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        
        // If length is less than 3, can't normalize properly
        if (trimmed.length() < 3) {
            return trimmed;
        }
        
        // Uppercase first 3 characters, leave rest untouched
        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String restOfCode = trimmed.substring(3);
        
        return publisherCode + restOfCode;
    }
    
    /**
     * Validates and formats a normalized ISBN code
     * @param code the normalized ISBN code
     * @return formatted ISBN display or error message
     */
    public static String validateAndFormat(String code) {
        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length (expected 13 characters, got " + code.length() + ")";
        }
        
        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }
        
        // Valid - format the output
        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7, 13);
        
        StringBuilder result = new StringBuilder();
        result.append("[").append(publisherCode).append("] ");
        result.append("YEAR: ").append(year).append(" | ");
        result.append("CATALOG: ").append(catalogNumber);
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // Sample test cases
        String raw1 = " pen2026004251 ";
        String normalized1 = normalizeCode(raw1);
        String result1 = validateAndFormat(normalized1);
        System.out.println(result1);
        // Output: [PEN] YEAR: 2026 | CATALOG: 004251
        
        String raw2 = "12N2026004251";
        String normalized2 = normalizeCode(raw2);
        String result2 = validateAndFormat(normalized2);
        System.out.println(result2);
        // Output: Invalid: publisher code must be 3 letters
    }
}
