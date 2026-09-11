import java.util.Arrays;

public class PlacementDriveEngine {
    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;
        
        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }
        
        double getCompositeScore() {
            return this.cgpa * 10 + this.codingScore;
        }
        
        @Override
        public int compareTo(Candidate other) {
            // Sort in descending order by composite score
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }
    
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }
    
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 7.5 || (cgpa >= 6.0 && codingScore >= 60);
    }
    
    static String shortlistAndRank(Candidate[] candidates) {
        // Filter eligible candidates
        java.util.List<Candidate> shortlisted = new java.util.ArrayList<>();
        for (Candidate candidate : candidates) {
            if (isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted.add(candidate);
            }
        }
        
        // Convert to array and sort
        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);
        
        // Format output
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append((i + 1)).append(". ").append(shortlistedArray[i].name)
                  .append(" (").append(shortlistedArray[i].getCompositeScore()).append(")");
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
