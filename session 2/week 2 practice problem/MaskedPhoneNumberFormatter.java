public class MaskedPhoneNumberFormatter {
    
    /**
     * Masks a phone number showing only the last 4 digits.
     * Accepts a 10-digit phone number and returns "XXXXXX-" followed by last 4 digits.
     * Returns error message if phone number is invalid.
     */
    String maskPhoneNumber(String phone) {
        // Validate that the phone number is exactly 10 digits
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        
        // Check that all characters are digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        
        // Extract the last 4 digits
        String lastFour = phone.substring(6);
        
        // Build masked number using StringBuilder
        StringBuilder maskedNumber = new StringBuilder();
        maskedNumber.append("XXXXXX");
        maskedNumber.append("-");
        maskedNumber.append(lastFour);
        
        return maskedNumber.toString();
    }
    
    public static void main(String[] args) {
        MaskedPhoneNumberFormatter formatter = new MaskedPhoneNumberFormatter();
        
        // Test case 1 - Valid 10-digit phone
        System.out.println(formatter.maskPhoneNumber("9876543210"));
        
        // Test case 2 - Invalid length (only 5 digits)
        System.out.println(formatter.maskPhoneNumber("98765"));
        
        // Test case 3 - Valid phone number
        System.out.println(formatter.maskPhoneNumber("1234567890"));
        
        // Test case 4 - Invalid (contains non-digit characters)
        System.out.println(formatter.maskPhoneNumber("987-654-3210"));
        
        // Test case 5 - Valid phone
        System.out.println(formatter.maskPhoneNumber("5551234567"));
    }
}
