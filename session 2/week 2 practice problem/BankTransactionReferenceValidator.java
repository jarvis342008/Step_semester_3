public class BankTransactionReferenceValidator {
    
    /**
     * Normalizes a raw reference string by trimming spaces and uppercasing the first 3 characters.
     * Raw reference format: 3 letters (bank code) + 6 digits (date, ddMMyy) + 5 digits (sequence)
     */
    String normalizeReference(String raw) {
        // Trim leading and trailing spaces
        String trimmed = raw.trim();
        
        // Check if we have at least 3 characters
        if (trimmed.length() < 3) {
            return trimmed;
        }
        
        // Uppercase the first 3 characters, leave the rest untouched
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        
        return bankCode + rest;
    }
    
    /**
     * Validates a normalized reference and returns a formatted display line.
     * Valid format: exactly 14 characters; first 3 are letters; remaining 11 are digits.
     * Displays as: "[BANKCODE] DATE: dd/MM/yy | SEQ: 12345"
     * Returns specific error if invalid.
     */
    String validateAndFormat(String reference) {
        // Validate length
        if (reference.length() != 14) {
            return "Invalid: length must be exactly 14 characters";
        }
        
        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        
        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: digits section must contain only numbers";
            }
        }
        
        // Extract components
        String bankCode = reference.substring(0, 3);
        String dateDigits = reference.substring(3, 9);  // 6 digits: ddMMyy
        String sequenceNumber = reference.substring(9, 14);  // 5 digits
        
        // Format date as dd/MM/yy
        String formattedDate = dateDigits.charAt(0) + "" + dateDigits.charAt(1) + "/" + 
                              dateDigits.charAt(2) + "" + dateDigits.charAt(3) + "/" + 
                              dateDigits.charAt(4) + "" + dateDigits.charAt(5);
        
        // Build formatted display using StringBuilder
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] ");
        formatted.append("DATE: ").append(formattedDate);
        formatted.append(" | SEQ: ").append(sequenceNumber);
        
        return formatted.toString();
    }
    
    public static void main(String[] args) {
        BankTransactionReferenceValidator validator = new BankTransactionReferenceValidator();
        
        // Test case 1 - Valid reference with spaces
        String raw1 = " hdf03022600042 ";
        String normalized1 = validator.normalizeReference(raw1);
        System.out.println(validator.validateAndFormat(normalized1));
        
        // Test case 2 - Invalid reference (bank code contains digits)
        String raw2 = "12F03022600042";
        String normalized2 = validator.normalizeReference(raw2);
        System.out.println(validator.validateAndFormat(normalized2));
        
        // Test case 3 - Valid reference
        String raw3 = "XYZ12062500123";
        String normalized3 = validator.normalizeReference(raw3);
        System.out.println(validator.validateAndFormat(normalized3));
        
        // Test case 4 - Valid reference with lowercase
        String raw4 = "abc15031900999";
        String normalized4 = validator.normalizeReference(raw4);
        System.out.println(validator.validateAndFormat(normalized4));
        
        // Test case 5 - Invalid (too short)
        String raw5 = "AB123";
        String normalized5 = validator.normalizeReference(raw5);
        System.out.println(validator.validateAndFormat(normalized5));
    }
}
