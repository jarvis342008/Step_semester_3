/**
 * A2. Maximum Subarray
 * 
 * Task: Find the contiguous subarray with the largest sum.
 * Constraints: O(n) time and O(1) space.
 */
public class A2_MaximumSubarray {
    
    /**
     * Returns the maximum sum of any contiguous subarray.
     * Uses Kadane's algorithm: at each element, decide whether to extend
     * the current running subarray or restart from the current element.
     * 
     * Time: O(n), Space: O(1)
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];      // Best sum found so far
        int currentSum = nums[0];  // Best sum ending at current position
        
        for (int i = 1; i < nums.length; i++) {
            // Decide: extend current subarray or start fresh from current element?
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the overall maximum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    // Test driver
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = maxSubArray(nums1);
        System.out.println("Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]");
        System.out.println("Output: " + result1); // Expected: 6 (subarray [4, -1, 2, 1])
        
        // Test case 2
        int[] nums2 = {-3, -1, -2};
        int result2 = maxSubArray(nums2);
        System.out.println("\nInput: [-3, -1, -2]");
        System.out.println("Output: " + result2); // Expected: -1 (single largest value)
        
        // Test case 3 - single positive element
        int[] nums3 = {5};
        int result3 = maxSubArray(nums3);
        System.out.println("\nInput: [5]");
        System.out.println("Output: " + result3); // Expected: 5
    }
}
