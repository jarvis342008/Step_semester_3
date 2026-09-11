public class CSVStudentRecordParser {
    
    /**
     * Parses a CSV line in the format "Name,RollNumber,Department"
     * and prints a formatted record or an error message.
     */
    void parseStudentRecord(String csvLine) {
        // Split the CSV line by comma
        String[] fields = csvLine.split(",");
        
        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        
        // Extract fields
        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();
        
        // Print formatted record
        System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department);
    }
    
    public static void main(String[] args) {
        CSVStudentRecordParser parser = new CSVStudentRecordParser();
        
        // Test case 1 - Valid record
        parser.parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        
        // Test case 2 - Invalid record (only 2 fields)
        parser.parseStudentRecord("Ananya Verma,CSE");
        
        // Test case 3 - Valid record
        parser.parseStudentRecord("Raj Kumar,RA2211003010124,ECE");
        
        // Test case 4 - Invalid record (too many fields)
        parser.parseStudentRecord("John Doe,RA2211003010125,IT,Extra");
    }
}
