public class VotingEligibility {
    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = (int)(Math.random() * 90) + 10;
        }
        return ages;
    }
    
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            
            if (ages[i] < 0) {
                result[i][1] = "Invalid";
            } else if (ages[i] >= 18) {
                result[i][1] = "Can Vote";
            } else {
                result[i][1] = "Cannot Vote";
            }
        }
        
        return result;
    }
    
    public static void displayTable(String[][] data) {
        System.out.println("\n===== Voting Eligibility Status =====");
        System.out.println("Age\tStatus");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }
    
    public static void main(String[] args) {
        int[] ages = generateRandomAges(10);
        String[][] eligibility = checkVotingEligibility(ages);
        displayTable(eligibility);
    }
}
