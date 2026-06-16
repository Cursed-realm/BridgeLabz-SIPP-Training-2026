import java.util.Scanner;

public class CountdownForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the countdown value: ");
        int counter = sc.nextInt();
        
        System.out.println("Rocket Launch Countdown:");
        
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
        
        System.out.println("Blastoff!");
        
        sc.close();
    }
}
