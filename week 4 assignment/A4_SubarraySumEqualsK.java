import java.util.*;

/**
 * A4. Subarray Sum Equals K
 * 
 * Task: Count the total number of contiguous subarrays with sum equal to k.
 * Constraints: O(n) time and O(n) space using hash map.
 */
public class A4_SubarraySumEqualsK {
    
    /**
     * Returns the number of contiguous subarrays whose sum equals k.
     * 
     * Approach:
     * - Use prefix sums: prefixSum[j] - prefixSum[i] = sum of subarray [i+1, j]
     * - At each position, check how many earlier prefix sums equal (currentSum - k)
     * - Store prefix sum frequencies in a hash map
     * - Handle the "empty prefix" (sum 0 before array starts) as base case
     * 
     * Time: O(n), Space: O(n)
     */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);  // Base case: empty prefix with sum 0
        
        int count = 0;
        int currentSum = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if there's a prefix sum that would create a subarray summing to k
            // If currentSum - k exists in the map, we found (currentSum - k) prefix sums
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }
            
            // Add current prefix sum to the map
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
    
    // Test driver
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        int result1 = subarraySum(nums1, k1);
        System.out.println("Input: nums = [1, 1, 1], k = 2");
        System.out.println("Output: " + result1); // Expected: 2 ([1,1] at 0-1 and 1-2)
        
        // Test case 2
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        int result2 = subarraySum(nums2, k2);
        System.out.println("\nInput: nums = [1, -1, 0], k = 0");
        System.out.println("Output: " + result2); // Expected: 3
        
        // Test case 3
        int[] nums3 = {1, 2, 3, 1, 1, 1};
        int k3 = 3;
        int result3 = subarraySum(nums3, k3);
        System.out.println("\nInput: nums = [1, 2, 3, 1, 1, 1], k = 3");
        System.out.println("Output: " + result3); // Expected: 3 ([3], [1,2], [1,1,1])
        
        // Test case 4 - with negative numbers
        int[] nums4 = {-1, -1, 1};
        int k4 = 0;
        int result4 = subarraySum(nums4, k4);
        System.out.println("\nInput: nums = [-1, -1, 1], k = 0");
        System.out.println("Output: " + result4); // Expected: 1 ([-1, -1, 1])
    }
}
