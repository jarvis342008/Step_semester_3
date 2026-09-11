/**
 * Product Inventory CSV Parser
 * Parses and validates inventory records in CSV format
 */
public class ProductInventoryParser {
    
    /**
     * Parses a CSV inventory line and prints formatted record
     * Expected format: "ProductName,SKU,Quantity"
     * @param csvLine the CSV line to parse
     */
    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            String productName = fields[0];
            String sku = fields[1];
            String quantity = fields[2];
            
            System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
        }
    }
    
    public static void main(String[] args) {
        // Sample test cases
        parseInventoryRecord("Wireless Mouse,WM-2201,150");  
        // Output: Product: Wireless Mouse | SKU: WM-2201 | Qty: 150
        
        parseInventoryRecord("Wireless Mouse,150");
        // Output: Invalid Record
    }
}
