public class SeatDuplicationChecker {
    public void checkDuplicateSeats(int[] seatNumbers) {
        // Track which duplicates have already been printed to avoid repetition
        boolean[] printed = new boolean[seatNumbers.length];
        boolean foundDuplicate = false;
        
        // Nested loop: compare each seat with all subsequent seats
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                // Check if current seat matches any later seat
                if (seatNumbers[i] == seatNumbers[j] && !printed[i]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    printed[i] = true;
                    foundDuplicate = true;
                }
            }
        }
        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }
    public static void main(String[] args) {
        SeatDuplicationChecker checker = new SeatDuplicationChecker();
        
        // Test case 1: Array with duplicates
        System.out.println("Test Case 1:");
        int[] testCase1 = {101, 102, 103, 102, 105};
        checker.checkDuplicateSeats(testCase1);
        
        System.out.println("\nTest Case 2:");
        // Test case 2: Array with no duplicates
        int[] testCase2 = {101, 102, 103, 104, 105};
        checker.checkDuplicateSeats(testCase2);
    }
}
