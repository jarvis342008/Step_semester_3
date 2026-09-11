/**
 * L1. Two Sum
 * 
 * Task: Find two numbers in an array that add up to a target value.
 * Using nested loops, check every pair of different positions (i, j) in the array.
 * If nums[i] + nums[j] equals target, return the two indices [i, j] immediately.
 */
public class L1_TwoSum {
    
    public static int[] twoSum(int[] nums, int target) {
        // Use nested loops to check every pair
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the pair adds up to target
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        // Should not reach here as per problem statement
        return new int[] { -1, -1 };
    }
    
    // Test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Input: nums = [2, 7, 11, 15], target = 9");
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");
        System.out.println("Expected: [0, 1] (nums[0] + nums[1] = 2 + 7 = 9)\n");
        
        // Test case 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Input: nums = [3, 2, 4], target = 6");
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");
        System.out.println("Expected: [1, 2] (nums[1] + nums[2] = 2 + 4 = 6)");
    }
}
