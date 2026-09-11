import java.util.*;

/**
 * A3. 3Sum
 * 
 * Task: Find all unique triplets that sum to zero.
 * Constraints: O(n²) time, handle duplicates carefully.
 */
public class A3_ThreeSum {
    
    /**
     * Returns all unique triplets [a, b, c] where a + b + c = 0.
     * 
     * Approach:
     * 1. Sort the array (O(n log n))
     * 2. For each element, use two-pointer technique to find pairs summing to -nums[i]
     * 3. Skip duplicates at all levels to avoid duplicate triplets
     * 
     * Time: O(n²), Space: O(1) excluding output
     */
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);  // Sort array first
        List<int[]> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values at the outer level
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // If the smallest possible sum (nums[i] + two smallest remaining)
            // is still positive, no triplet can sum to 0
            if (nums[i] > 0) {
                break;
            }
            
            // Find two numbers that sum to -nums[i]
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    // Found a valid triplet
                    result.add(new int[]{nums[i], nums[left], nums[right]});
                    
                    // Skip duplicates on the left side
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates on the right side
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result.toArray(new int[0][]);
    }
    
    // Test driver
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] result1 = threeSum(nums1);
        System.out.println("Input: [-1, 0, 1, 2, -1, -4]");
        System.out.println("Output: ");
        for (int[] triplet : result1) {
            System.out.println(Arrays.toString(triplet));
        }
        // Expected: [[-1, -1, 2], [-1, 0, 1]]
        
        // Test case 2
        int[] nums2 = {0, 0, 0};
        int[][] result2 = threeSum(nums2);
        System.out.println("\nInput: [0, 0, 0]");
        System.out.println("Output: ");
        for (int[] triplet : result2) {
            System.out.println(Arrays.toString(triplet));
        }
        // Expected: [[0, 0, 0]]
        
        // Test case 3
        int[] nums3 = {-2, 0, 1, 1, 2};
        int[][] result3 = threeSum(nums3);
        System.out.println("\nInput: [-2, 0, 1, 1, 2]");
        System.out.println("Output: ");
        for (int[] triplet : result3) {
            System.out.println(Arrays.toString(triplet));
        }
        // Expected: [[-2, 0, 2], [-2, 1, 1]]
    }
}
