public class InventoryBalancer {
    public void analyzeInventory(int[] sectionA, int[] sectionB) {
        // Ensure both arrays are of equal length
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: Both sections must have equal number of items.");
            return;
        }
        
        // Compute totals for each section
        int totalA = 0;
        int totalB = 0;
        
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }
        
        // Determine balance status
        String balanceStatus = (totalA == totalB) ? "Balanced" : "Not Balanced";
        
        // Find the highest quantity across both sections
        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 1; // 1-indexed for user display
        
        // Check Section A
        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i + 1; // Convert to 1-indexed
            }
        }
        
        // Check Section B
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i + 1; // Convert to 1-indexed
            }
        }
        
        // Print the analysis results
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + 
                         " | Status: " + balanceStatus + " | Highest Quantity: " + highestQuantity + 
                         " (" + highestSection + ", Item " + highestIndex + ")");
    }
    

    public static void main(String[] args) {
        InventoryBalancer balancer = new InventoryBalancer();
        
        // Test case 1: Balanced sections with highest in Section A
        System.out.println("Test Case 1:");
        int[] sectionA1 = {20, 15, 30};
        int[] sectionB1 = {25, 10, 30};
        balancer.analyzeInventory(sectionA1, sectionB1);
        
        System.out.println("\nTest Case 2:");
        // Test case 2: Not balanced sections with highest in Section B
        int[] sectionA2 = {10, 20, 15};
        int[] sectionB2 = {12, 25, 18};
        balancer.analyzeInventory(sectionA2, sectionB2);
        
        System.out.println("\nTest Case 3:");
        // Test case 3: Balanced with different highest values
        int[] sectionA3 = {50, 10, 20};
        int[] sectionB3 = {15, 30, 35};
        balancer.analyzeInventory(sectionA3, sectionB3);
        
        System.out.println("\nTest Case 4:");
        // Test case 4: Single item in each section
        int[] sectionA4 = {100};
        int[] sectionB4 = {100};
        balancer.analyzeInventory(sectionA4, sectionB4);
    }
}
