public class EmployeeIdInsertionSort {
    public static void main(String[] args) {
        int[] employeeIds = { 5023, 1042, 8890, 3021, 6754 };
        insertionSort(employeeIds);
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
    }

    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];
            int j = i - 1;
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }
            employeeIds[j + 1] = key;
        }
    }
}
