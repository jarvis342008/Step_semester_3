/**
 * ATM PIN Length Validator
 * Checks that a PIN is exactly 4 digits long
 */
public class ATMPinValidator {
    
    /**
     * Checks if the PIN is exactly 4 digits long
     * @param pin the PIN string to validate
     */
    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
    
    public static void main(String[] args) {
        // Sample test cases
        checkPinLength("482");      // Output: Invalid PIN — must be exactly 4 digits.
        checkPinLength("4820");     // Output: PIN length OK.
    }
}
