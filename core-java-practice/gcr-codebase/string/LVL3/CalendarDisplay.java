import java.util.Scanner;

public class CalendarDisplay {
    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                          "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }
    
    public static int getNumberOfDays(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        
        return days[month - 1];
    }
    
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public static int getFirstDayOfMonth(int month, int year) {
        int y = year;
        int m = month;
        
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (1 + x + 31 * m0 / 12) % 7;
        
        return d0;
    }
    
    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int numberOfDays = getNumberOfDays(month, year);
        int firstDay = getFirstDayOfMonth(month, year);
        
        System.out.println("\n===== " + monthName + " " + year + " =====");
        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
        
        for (int i = 0; i < firstDay; i++) {
            System.out.print("\t");
        }
        
        for (int day = 1; day <= numberOfDays; day++) {
            System.out.print(day + "\t");
            
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        
        if (month >= 1 && month <= 12) {
            displayCalendar(month, year);
        } else {
            System.out.println("Invalid month!");
        }
        
        scanner.close();
    }
}
