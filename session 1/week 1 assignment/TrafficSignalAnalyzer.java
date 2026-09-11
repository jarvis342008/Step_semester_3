public class TrafficSignalAnalyzer {
    public void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("Error: Signal log cannot be empty.");
            return;
        }
        
        char longestColor = signalLog.charAt(0);
        int longestLength = 1;
        
        char currentColor = signalLog.charAt(0);
        int currentLength = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
    
                currentLength++;
            } else {
              
                if (currentLength > longestLength) {
                    longestLength = currentLength;
                    longestColor = currentColor;
                }
                
               
                currentColor = signalLog.charAt(i);
                currentLength = 1;
            }
        }
        
        
        if (currentLength > longestLength) {
            longestLength = currentLength;
            longestColor = currentColor;
        }
        
       
        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }
    
   
    public static void main(String[] args) {
        TrafficSignalAnalyzer analyzer = new TrafficSignalAnalyzer();
        
       
        System.out.println("Test Case 1:");
        String signalLog1 = "RRGGGYRR";
        analyzer.findLongestStreak(signalLog1);
        
        System.out.println("\nTest Case 2:");
        
        String signalLog2 = "RRRRYYGG";
        analyzer.findLongestStreak(signalLog2);
        
        System.out.println("\nTest Case 3:");
        
        String signalLog3 = "YYYYY";
        analyzer.findLongestStreak(signalLog3);
        
        System.out.println("\nTest Case 4:");
        
        String signalLog4 = "RYGRYRG";
        analyzer.findLongestStreak(signalLog4);
    }
}
