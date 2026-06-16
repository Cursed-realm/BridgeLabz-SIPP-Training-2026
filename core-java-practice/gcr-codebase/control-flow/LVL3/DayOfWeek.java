public class DayOfWeek {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide month, day, and year as command line arguments");
            return;
        }
        
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        
        // Adjust month and year for Jan and Feb
        if (m < 3) {
            m = m + 12;
            y = y - 1;
        }
        
        // Zeller's formula
        int q = d;
        int K = y % 100;
        int J = y / 100;
        
        int h = (q + (13 * (m + 1)) / 5 + K + K / 4 + J / 4 - 2 * J) % 7;
        
        // Convert to day of week (0 = Sunday, 1 = Monday, etc.)
        int dayOfWeek = (h + 6) % 7;
        
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        System.out.println("Date: " + args[1] + "/" + args[0] + "/" + args[2]);
        System.out.println("Day of week: " + dayOfWeek + " (" + days[dayOfWeek] + ")");
    }
}
