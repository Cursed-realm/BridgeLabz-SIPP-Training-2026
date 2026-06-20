import java.util.Scanner;

public class MatrixOperations2 {
    
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int)(Math.random() * 10);
            }
        }
        return matrix;
    }
    
    public static void displayMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public static void displayMatrixDouble(double[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(String.format("%.2f", matrix[i][j]) + "\t");
            }
            System.out.println();
        }
    }
    
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    
    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }
    
    public static int determinant3x3(int[][] matrix) {
        int det = matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        return det;
    }
    
    public static double[][] inverse2x2(int[][] matrix) {
        int det = determinant2x2(matrix);
        if (det == 0) {
            return null;
        }
        
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / (double) det;
        inverse[0][1] = -matrix[0][1] / (double) det;
        inverse[1][0] = -matrix[1][0] / (double) det;
        inverse[1][1] = matrix[0][0] / (double) det;
        
        return inverse;
    }
    
    public static double[][] inverse3x3(int[][] matrix) {
        int det = determinant3x3(matrix);
        if (det == 0) {
            return null;
        }
        
        double[][] inverse = new double[3][3];
        
        inverse[0][0] = (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) / (double) det;
        inverse[0][1] = (matrix[0][2] * matrix[2][1] - matrix[0][1] * matrix[2][2]) / (double) det;
        inverse[0][2] = (matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1]) / (double) det;
        
        inverse[1][0] = (matrix[1][2] * matrix[2][0] - matrix[1][0] * matrix[2][2]) / (double) det;
        inverse[1][1] = (matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0]) / (double) det;
        inverse[1][2] = (matrix[0][2] * matrix[1][0] - matrix[0][0] * matrix[1][2]) / (double) det;
        
        inverse[2][0] = (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]) / (double) det;
        inverse[2][1] = (matrix[0][1] * matrix[2][0] - matrix[0][0] * matrix[2][1]) / (double) det;
        inverse[2][2] = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]) / (double) det;
        
        return inverse;
    }
    
    public static void main(String[] args) {
        int[][] matrix2x2 = createRandomMatrix(2, 2);
        int[][] matrix3x3 = createRandomMatrix(3, 3);
        
        System.out.println("=== 2x2 Matrix Operations ===");
        System.out.println("Original Matrix:");
        displayMatrix(matrix2x2);
        
        System.out.println("\nTranspose:");
        displayMatrix(transposeMatrix(matrix2x2));
        
        int det2 = determinant2x2(matrix2x2);
        System.out.println("\nDeterminant: " + det2);
        
        if (det2 != 0) {
            System.out.println("Inverse:");
            displayMatrixDouble(inverse2x2(matrix2x2));
        } else {
            System.out.println("Inverse: Does not exist (Determinant is 0)");
        }
        
        System.out.println("\n\n=== 3x3 Matrix Operations ===");
        System.out.println("Original Matrix:");
        displayMatrix(matrix3x3);
        
        System.out.println("\nTranspose:");
        displayMatrix(transposeMatrix(matrix3x3));
        
        int det3 = determinant3x3(matrix3x3);
        System.out.println("\nDeterminant: " + det3);
        
        if (det3 != 0) {
            System.out.println("Inverse:");
            displayMatrixDouble(inverse3x3(matrix3x3));
        } else {
            System.out.println("Inverse: Does not exist (Determinant is 0)");
        }
    }
}
