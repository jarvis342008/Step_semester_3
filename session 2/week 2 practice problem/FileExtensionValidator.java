public class FileExtensionValidator {
    
    /**
     * Validates whether a filename has an accepted extension.
     * Accepted extensions: pdf, docx, zip (case-insensitive)
     * Returns "Accepted" or "Rejected — invalid file type"
     */
    String validateFileExtension(String filename) {
        // Find the last occurrence of '.'
        int lastDotIndex = filename.lastIndexOf('.');
        
        // Check if '.' exists and is not at the beginning or end
        if (lastDotIndex <= 0 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        
        // Extract the extension (everything after the last '.')
        String extension = filename.substring(lastDotIndex + 1).toLowerCase();
        
        // Check if extension is in the accepted list
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        
        return "Rejected — invalid file type";
    }
    
    public static void main(String[] args) {
        FileExtensionValidator validator = new FileExtensionValidator();
        
        // Test case 1 - PDF with uppercase
        System.out.println(validator.validateFileExtension("Assignment1.PDF"));
        
        // Test case 2 - Invalid extension
        System.out.println(validator.validateFileExtension("notes.txt"));
        
        // Test case 3 - Valid DOCX
        System.out.println(validator.validateFileExtension("report.docx"));
        
        // Test case 4 - Valid ZIP
        System.out.println(validator.validateFileExtension("archive.zip"));
        
        // Test case 5 - No extension
        System.out.println(validator.validateFileExtension("file"));
        
        // Test case 6 - Hidden file
        System.out.println(validator.validateFileExtension(".hidden"));
    }
}
