import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CircularDependencyDetector {
    public static boolean hasCircularDependency(Map<Integer, List<Integer>> tasks, int n) {
        int[] state = new int[n]; // 0 = WHITE, 1 = GRAY, 2 = BLACK
        for (int v = 0; v < n; v++) {
            if (state[v] == 0) {
                if (dfsCycleCheck(tasks, v, state)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsCycleCheck(Map<Integer, List<Integer>> tasks, int node, int[] state) {
        state[node] = 1;
        for (int dep : tasks.getOrDefault(node, Collections.emptyList())) {
            if (state[dep] == 1) {
                return true;
            }
            if (state[dep] == 0 && dfsCycleCheck(tasks, dep, state)) {
                return true;
            }
        }
        state[node] = 2;
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> tasks = Map.of(
            0, List.of(1),
            1, List.of(2),
            2, List.of(3),
            3, List.of(1)
        );

        System.out.println("Has circular dependency: " + hasCircularDependency(tasks, 4));
    }
}
