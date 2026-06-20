import java.util.Scanner;

public class CalendarDisplay {
    
    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                          "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }
    
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
        return year % 4 == 0;
    }
    
    public static int getDaysInMonth(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }
    
    public static int getFirstDayOfMonth(int month, int year) {
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int q = 1;
        int m = month;
        int k = year % 100;
        int j = year / 100;
        int h = (q + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) - 2 * j) % 7;
        return (h + 6) % 7;
    }
    
    public static void displayCalendar(int month, int year) {
        System.out.println("\n" + getMonthName(month) + " " + year);
        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
        
        int firstDay = getFirstDayOfMonth(month, year);
        int daysInMonth = getDaysInMonth(month, year);
        
        for (int i = 0; i < firstDay; i++) {
            System.out.print("\t");
        }
        
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.print(day + "\t");
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        
        if (month < 1 || month > 12) {
            System.out.println("Invalid month");
        } else if (year < 1582) {
            System.out.println("Year must be >= 1582");
        } else {
            displayCalendar(month, year);
        }
        
        sc.close();
    }
}
