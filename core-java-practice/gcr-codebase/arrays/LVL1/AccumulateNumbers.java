import java.util.Scanner;

public class AccumulateNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        System.out.println("Enter numbers (enter 0 or negative number to stop):");
        
        while (true) {
            System.out.print("Enter a number: ");
            double number = scanner.nextDouble();
            
            if (number <= 0) {
                break;
            }
            
            if (index >= 10) {
                System.out.println("Array is full. Stopping input.");
                break;
            }
            
            numbers[index] = number;
            index++;
        }
        
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }
        
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }
        
        System.out.println("\nTotal sum: " + total);
        
        scanner.close();
    }
}
