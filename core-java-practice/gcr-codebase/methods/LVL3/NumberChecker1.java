import java.util.Scanner;

public class NumberChecker1 {
    
    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    
    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int index = count - 1;
        while (number > 0) {
            digits[index] = number % 10;
            number /= 10;
            index--;
        }
        return digits;
    }
    
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isArmstrongNumber(int number, int[] digits) {
        int count = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, count);
        }
        return sum == number;
    }
    
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        
        return new int[]{largest, secondLargest};
    }
    
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        
        return new int[]{smallest, secondSmallest};
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int[] digits = storeDigits(number);
        
        System.out.println("\nNumber: " + number);
        System.out.println("Digit Count: " + countDigits(number));
        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();
        
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrongNumber(number, digits));
        
        int[] largestPair = findLargestAndSecondLargest(digits);
        System.out.println("Largest: " + largestPair[0] + ", Second Largest: " + largestPair[1]);
        
        int[] smallestPair = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest: " + smallestPair[0] + ", Second Smallest: " + smallestPair[1]);
        
        sc.close();
    }
}
