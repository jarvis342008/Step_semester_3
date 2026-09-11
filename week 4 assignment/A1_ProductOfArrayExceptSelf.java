/**
 * A1. Product of Array Except Self
 * 
 * Task: For each index i, return the product of all elements except nums[i].
 * Constraints: No division allowed, O(n) time, O(1) extra space (excluding output array).
 */
public class A1_ProductOfArrayExceptSelf {
    
    /**
     * Returns an array where answer[i] is the product of every element
     * except nums[i], without using division.
     * 
     * Approach:
     * - First pass: Calculate products of all elements to the left of each index
     * - Second pass: Multiply in the products of all elements to the right
     * - This gives us the product of all elements except the current one
     * 
     * Time: O(n), Space: O(1) excluding output array
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // First pass: fill answer with left products
        // answer[i] = product of all elements to the left of index i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Second pass: multiply by right products
        // rightProduct starts as 1 and accumulates products from right to left
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        return answer;
    }
    
    // Test driver
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelf(nums1);
        System.out.print("Input: [1, 2, 3, 4], Output: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) System.out.print(", ");
        }
        System.out.println("]"); // Expected: [24, 12, 8, 6]
        
        // Test case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelf(nums2);
        System.out.print("Input: [-1, 1, 0, -3, 3], Output: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) System.out.print(", ");
        }
        System.out.println("]"); // Expected: [0, 0, 9, 0, 0]
    }
}
