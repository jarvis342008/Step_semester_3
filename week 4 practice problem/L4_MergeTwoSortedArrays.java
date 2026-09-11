/**
 * L4. Merge Two Sorted Arrays
 * 
 * Task: Merge two sorted arrays into one sorted array without re-sorting from scratch.
 * Keep one index pointer for each array, both starting at 0.
 * Compare current elements and copy the smaller one into result, moving that array's pointer forward.
 * Once one array is fully copied, copy remaining elements from the other array.
 */
public class L4_MergeTwoSortedArrays {
    
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int i = 0;        // Pointer for arr1
        int j = 0;        // Pointer for arr2
        int k = 0;        // Pointer for result array
        
        // Create result array with total size
        int[] result = new int[arr1.length + arr2.length];
        
        // Compare and copy elements from both arrays
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        
        // Copy remaining elements from arr1, if any
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        
        // Copy remaining elements from arr2, if any
        while (j < arr2.length) {
            result[k++] = arr2[j++];
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
        int[] arr1_1 = { 1, 3, 5 };
        int[] arr2_1 = { 2, 4, 6 };
        int[] result1 = mergeSortedArrays(arr1_1, arr2_1);
        System.out.println("Input: arr1 = [1, 3, 5], arr2 = [2, 4, 6]");
        System.out.print("Output: ");
        printArray(result1);
        System.out.println("Expected: [1, 2, 3, 4, 5, 6]\n");
        
        // Test case 2
        int[] arr1_2 = { };
        int[] arr2_2 = { 1, 2, 3 };
        int[] result2 = mergeSortedArrays(arr1_2, arr2_2);
        System.out.println("Input: arr1 = [], arr2 = [1, 2, 3]");
        System.out.print("Output: ");
        printArray(result2);
        System.out.println("Expected: [1, 2, 3]");
    }
}
