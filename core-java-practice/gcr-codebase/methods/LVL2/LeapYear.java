import java.util.Scanner;

public class LeapYear {
    
    public static boolean isLeapYear(int year) {
        if (year < 1582) {
            return false;
        }
        
        if (year % 400 == 0) {
            return true;
        }
        
        if (year % 100 == 0) {
            return false;
        }
        
        if (year % 4 == 0) {
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a year (>= 1582): ");
        int year = sc.nextInt();
        
        if (year < 1582) {
            System.out.println("Year must be >= 1582 (Gregorian calendar)");
        } else if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
        
        sc.close();
    }
}
