import java.util.Scanner;

public class ReverseCustomerName {

    /**
     * Reverses the given customer name
     */
    public static String reverseCustomerName(String customerName) {
        // Convert string to character array
        char[] chars = customerName.toCharArray();
        
        // Reverse the array by swapping from both ends
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            // Swap characters
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
        
        // Convert back to string
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========== Customer Identity Verification System ==========\n");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        
        String reversedName = reverseCustomerName(customerName);
        
        System.out.println("\n========== Verification Result ==========");
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
        
        scanner.close();
    }
}
