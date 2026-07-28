import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NetworkConnectivityAudit {
    public static int countNetworkSegments(Map<Integer, List<Integer>> network, int n) {
        Set<Integer> visited = new HashSet<>();
        int segments = 0;
        for (int server = 0; server < n; server++) {
            if (!visited.contains(server)) {
                segments++;
                dfs(network, server, visited);
            }
        }
        return segments;
    }

    private static void dfs(Map<Integer, List<Integer>> network, int node, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : network.getOrDefault(node, List.of())) {
            if (!visited.contains(neighbor)) {
                dfs(network, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> network = Map.of(
            0, List.of(1),
            1, List.of(0, 2),
            2, List.of(1),
            3, List.of(4),
            4, List.of(3)
        );
        int segments = countNetworkSegments(network, 5);
        System.out.println("Segments: " + segments);
        System.out.println("Fully connected: " + (segments == 1));
    }
}
