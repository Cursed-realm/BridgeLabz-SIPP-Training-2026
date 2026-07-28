import java.util.ArrayList;
import java.util.List;

public class SensorPlacementNQueens {
    public static List<List<String>> placeSensors(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] sensorCol = new int[n];
        backtrack(n, 0, sensorCol, result);
        return result;
    }

    private static void backtrack(int n, int row, int[] sensorCol, List<List<String>> result) {
        if (row == n) {
            result.add(buildGrid(n, sensorCol));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, sensorCol)) {
                sensorCol[row] = col;
                backtrack(n, row + 1, sensorCol, result);
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] sensorCol) {
        for (int r = 0; r < row; r++) {
            if (sensorCol[r] == col) {
                return false;
            }
            if (Math.abs(sensorCol[r] - col) == Math.abs(r - row)) {
                return false;
            }
        }
        return true;
    }

    private static List<String> buildGrid(int n, int[] sensorCol) {
        List<String> grid = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int col = 0; col < n; col++) {
                rowBuilder.append(col == sensorCol[row] ? 'Q' : '.');
            }
            grid.add(rowBuilder.toString());
        }
        return grid;
    }

    public static void main(String[] args) {
        System.out.println(placeSensors(4));
    }
}