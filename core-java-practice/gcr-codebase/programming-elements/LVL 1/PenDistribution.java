public class PenDistribution {
    public static void main(String[] args) {
        int totalPens = 14;
        int students = 3;
        
        int penPerStudent = totalPens / students;
        int remainingPens = totalPens % students;
        
        System.out.println("The Pen Per Student is " + penPerStudent + " and the remaining pen not distributed is " + remainingPens);
    }
}
