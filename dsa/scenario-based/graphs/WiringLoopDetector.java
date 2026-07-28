import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WiringLoopDetector {
    public static boolean hasWiringLoop(Map<Integer, List<Integer>> circuit, int n) {
        Set<Integer> visited = new HashSet<>();
        for (int v = 0; v < n; v++) {
            if (!visited.contains(v)) {
                if (dfsCycleCheck(circuit, v, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsCycleCheck(Map<Integer, List<Integer>> circuit, int node, int parent, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : circuit.getOrDefault(node, List.of())) {
            if (!visited.contains(neighbor)) {
                if (dfsCycleCheck(circuit, neighbor, node, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> circuit = Map.of(
            0, List.of(1, 2),
            1, List.of(0, 2),
            2, List.of(0, 1),
            3, List.of(4),
            4, List.of(3)
        );
        System.out.println("Contains loop: " + hasWiringLoop(circuit, 5));
    }
}
