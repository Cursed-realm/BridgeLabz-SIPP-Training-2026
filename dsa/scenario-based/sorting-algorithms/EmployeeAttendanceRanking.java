import java.util.Arrays;

public class EmployeeAttendanceRanking {
    public static void main(String[] args) {
        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int k = 3;
        int[] result = getTopKEmployees(employeeIds, attendance, k);
        for (int id : result) {
            System.out.print(id + " ");
        }
    }

    public static int[] getTopKEmployees(int[] employeeIds, int[] attendance, int k) {
        int n = employeeIds.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> {
            if (attendance[a] != attendance[b]) {
                return attendance[b] - attendance[a];
            }
            return employeeIds[a] - employeeIds[b];
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = employeeIds[indices[i]];
        }
        return result;
    }
}
