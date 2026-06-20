import java.util.Scanner;

public class ChocolateDistribution {
    
    public static int[] distributeChocolates(int numberOfChocolates, int numberOfChildren) {
        int perChild = numberOfChocolates / numberOfChildren;
        int remaining = numberOfChocolates % numberOfChildren;
        return new int[]{perChild, remaining};
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = sc.nextInt();
        
        System.out.print("Enter number of children: ");
        int numberOfChildren = sc.nextInt();
        
        if (numberOfChildren == 0) {
            System.out.println("Number of children cannot be zero");
        } else {
            int[] result = distributeChocolates(numberOfChocolates, numberOfChildren);
            System.out.println("Chocolates per child: " + result[0]);
            System.out.println("Remaining chocolates: " + result[1]);
        }
        
        sc.close();
    }
}
