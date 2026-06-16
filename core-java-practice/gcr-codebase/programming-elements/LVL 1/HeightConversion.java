import java.util.Scanner;

public class HeightConversion {
    public static void main(String[] args) {
        double heightCm;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        heightCm = input.nextDouble();
        double totalInches = heightCm / 2.54;
        double feet = totalInches / 12;
        double remainingInches = totalInches % 12;
        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + remainingInches);
        input.close();
    }
}
