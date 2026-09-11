/**
 * A5. Find Minimum in Rotated Sorted Array
 * 
 * Task: Find the minimum element in a rotated sorted array.
 * Constraints: O(log n) time using binary search.
 */
public class A5_FindMinInRotatedSortedArray {
    
    /**
     * Returns the minimum element in a rotated sorted array using binary search.
     * 
     * Approach:
     * - Use modified binary search to avoid O(n) linear scan
     * - Compare the middle element to the rightmost element:
     *   - If mid > right: minimum must be in the right half (rotation point is on right)
     *   - If mid < right: minimum must be in the left half (or at mid)
     *   - If mid == right: can't determine, reduce right by 1 (rare case with duplicates)
     * - Handle already-sorted arrays (no rotation) correctly
     * 
     * Time: O(log n), Space: O(1)
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Compare middle to rightmost element
            if (nums[mid] > nums[right]) {
                // Minimum must be in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half or at mid
                right = mid;
            }
        }
        
        return nums[left];
    }
    
    // Test driver
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        int result1 = findMin(nums1);
        System.out.println("Input: [3, 4, 5, 1, 2]");
        System.out.println("Output: " + result1); // Expected: 1
        
        // Test case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int result2 = findMin(nums2);
        System.out.println("\nInput: [4, 5, 6, 7, 0, 1, 2]");
        System.out.println("Output: " + result2); // Expected: 0
        
        // Test case 3 - no rotation
        int[] nums3 = {11, 13, 15, 17};
        int result3 = findMin(nums3);
        System.out.println("\nInput: [11, 13, 15, 17]");
        System.out.println("Output: " + result3); // Expected: 11
        
        // Test case 4 - rotated at end
        int[] nums4 = {2, 1};
        int result4 = findMin(nums4);
        System.out.println("\nInput: [2, 1]");
        System.out.println("Output: " + result4); // Expected: 1
        
        // Test case 5 - single element
        int[] nums5 = {5};
        int result5 = findMin(nums5);
        System.out.println("\nInput: [5]");
        System.out.println("Output: " + result5); // Expected: 5
    }
}
