/**
 * L5. Rotate Array
 * 
 * Task: Rotate array to the right by k positions.
 * First reduce k using k = k % nums.length to handle wraparound.
 * Create a new array and place each element at its new position: newArray[(i + k) % nums.length] = nums[i].
 * Copy values back to original array (or return the new array).
 */
public class L5_RotateArray {
    
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        // Reduce k to handle cases where k > nums.length
        k = k % nums.length;
        
        // Create a new array to hold rotated elements
        int[] result = new int[nums.length];
        
        // Place each element at its new position after rotation
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        
        return result;
    }
    
    // Helper method to print array
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    // Test the solution
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
        int k1 = 3;
        int[] result1 = rotateArray(nums1, k1);
        System.out.println("Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3");
        System.out.print("Output: ");
        printArray(result1);
        System.out.println("Expected: [5, 6, 7, 1, 2, 3, 4]\n");
        
        // Test case 2
        int[] nums2 = { 1, 2 };
        int k2 = 3;
        int[] result2 = rotateArray(nums2, k2);
        System.out.println("Input: nums = [1, 2], k = 3");
        System.out.print("Output: ");
        printArray(result2);
        System.out.println("Expected: [2, 1] (k % length = 3 % 2 = 1, a single rotation)");
    }
}
