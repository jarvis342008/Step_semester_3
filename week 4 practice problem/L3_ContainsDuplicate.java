/**
 * L3. Contains Duplicate
 * 
 * Task: Check if an array contains any duplicate values.
 * Using two nested loops, compare every element at position i against every element at a different position j.
 * If any matching pair is found, return true immediately.
 */
public class L3_ContainsDuplicate {
    
    public static boolean containsDuplicate(int[] nums) {
        // Use nested loops to check every pair
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // If two different positions hold the same value
                if (nums[i] == nums[j]) {
                    return true;  // Found a duplicate, exit immediately
                }
            }
        }
        
        // No matching pair found
        return false;
    }
    
    // Test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = { 1, 2, 3, 1 };
        boolean result1 = containsDuplicate(nums1);
        System.out.println("Input: nums = [1, 2, 3, 1]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: true (the value 1 appears at two different positions)\n");
        
        // Test case 2
        int[] nums2 = { 1, 2, 3, 4 };
        boolean result2 = containsDuplicate(nums2);
        System.out.println("Input: nums = [1, 2, 3, 4]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: false (every value is distinct)");
    }
}
