import java.util.Scanner;

public class YoungstTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter details for Amar:");
        System.out.print("Age: ");
        int amarAge = sc.nextInt();
        System.out.print("Height: ");
        double amarHeight = sc.nextDouble();
        
        System.out.println("Enter details for Akbar:");
        System.out.print("Age: ");
        int akbarAge = sc.nextInt();
        System.out.print("Height: ");
        double akbarHeight = sc.nextDouble();
        
        System.out.println("Enter details for Anthony:");
        System.out.print("Age: ");
        int anthonyAge = sc.nextInt();
        System.out.print("Height: ");
        double anthonyHeight = sc.nextDouble();
        
        // Find youngest
        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        String youngest = "";
        if (amarAge == youngestAge) {
            youngest = "Amar";
        } else if (akbarAge == youngestAge) {
            youngest = "Akbar";
        } else {
            youngest = "Anthony";
        }
        
        // Find tallest
        double tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));
        String tallest = "";
        if (amarHeight == tallestHeight) {
            tallest = "Amar";
        } else if (akbarHeight == tallestHeight) {
            tallest = "Akbar";
        } else {
            tallest = "Anthony";
        }
        
        System.out.println("Youngest friend: " + youngest + " (Age: " + youngestAge + ")");
        System.out.println("Tallest friend: " + tallest + " (Height: " + tallestHeight + ")");
        
        sc.close();
    }
}
