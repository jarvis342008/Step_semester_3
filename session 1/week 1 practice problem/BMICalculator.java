import java.util.Random;

public class BMICalculator {

    /**
     * Classifies health status based on BMI value
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    
    /**
     * Calculates BMI = weight / (height * height)
     */
    public static double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }
    
    /**
     * Prints a wellness report table for the team
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("\n========== Corporate Wellness Report ==========\n");
        System.out.println(String.format("%-10s %-15s %-15s %-15s %-15s", 
            "Person", "Height (m)", "Weight (kg)", "BMI", "Status"));
        System.out.println("--------------------------------------------------------------------------");
        
        for (int i = 0; i < heights.length; i++) {
            double bmi = calculateBMI(heights[i], weights[i]);
            String status = getBmiStatus(bmi);
            System.out.println(String.format("%-10d %-15.2f %-15.2f %-15.2f %-15s", 
                i + 1, heights[i], weights[i], bmi, status));
        }
    }

    public static void main(String[] args) {
        final int TEAM_SIZE = 10;
        double[] heights = new double[TEAM_SIZE];
        double[] weights = new double[TEAM_SIZE];
        
        // Generate random values for demo
        Random random = new Random();
        
        System.out.println("========== Generating Employee Data ==========\n");
        
        for (int i = 0; i < TEAM_SIZE; i++) {
            // Height: 1.50 to 2.00 meters
            heights[i] = 1.50 + (random.nextDouble() * 0.50);
            
            // Weight: 45 to 120 kg
            weights[i] = 45 + (random.nextDouble() * 75);
            
            System.out.println("Person " + (i + 1) + " - Height: " + 
                String.format("%.2f", heights[i]) + " m, Weight: " + 
                String.format("%.2f", weights[i]) + " kg");
        }
        
        // Print the wellness report
        printWellnessReport(heights, weights);
    }
}
