import java.util.Scanner;

public class RandomNumberAnalysis {
    
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = 1000 + (int)(Math.random() * 9000);
        }
        return numbers;
    }
    
    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        
        for (int number : numbers) {
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        double average = sum / numbers.length;
        return new double[]{average, min, max};
    }
    
    public static void main(String[] args) {
        System.out.println("Generating 5 four-digit random numbers:");
        
        int[] randomNumbers = generate4DigitRandomArray(5);
        
        System.out.print("Random numbers: ");
        for (int number : randomNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        
        double[] result = findAverageMinMax(randomNumbers);
        
        double average = result[0];
        int min = (int) result[1];
        int max = (int) result[2];
        
        System.out.println("Average: " + average);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}
