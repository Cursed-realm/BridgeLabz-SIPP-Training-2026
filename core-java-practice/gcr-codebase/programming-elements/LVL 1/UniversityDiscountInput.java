import java.util.Scanner;

public class UniversityDiscountInput {
    public static void main(String[] args) {
        double fee;
        double discountPercent;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Student Fee: ");
        fee = input.nextDouble();
        
        System.out.print("Enter Discount Percentage: ");
        discountPercent = input.nextDouble();
        
        double discount = (discountPercent / 100) * fee;
        double discountedFee = fee - discount;
        
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + discountedFee);
        
        input.close();
    }
}
