import java.util.Scanner;

public class StudentVoteChecker {
    
    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();
        
        int[] ages = new int[10];
        
        System.out.println("Enter ages of 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            ages[i] = sc.nextInt();
        }
        
        System.out.println("\nVoting Eligibility:");
        for (int i = 0; i < 10; i++) {
            if (ages[i] < 0) {
                System.out.println("Student " + (i + 1) + " (Age: " + ages[i] + "): Invalid age");
            } else if (checker.canStudentVote(ages[i])) {
                System.out.println("Student " + (i + 1) + " (Age: " + ages[i] + "): Can Vote");
            } else {
                System.out.println("Student " + (i + 1) + " (Age: " + ages[i] + "): Cannot Vote");
            }
        }
        
        sc.close();
    }
}
