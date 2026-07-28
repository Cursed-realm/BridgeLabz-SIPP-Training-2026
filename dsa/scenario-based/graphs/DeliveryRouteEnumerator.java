import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeliveryRouteEnumerator {
    public static List<List<Integer>> allRoutes(Map<Integer, List<Integer>> roads, int start, int target) {
        List<List<Integer>> allRoutes = new ArrayList<>();
        dfs(roads, start, target, new ArrayList<>(), new HashSet<>(), allRoutes);
        return allRoutes;
    }

    private static void dfs(Map<Integer, List<Integer>> roads, int current, int target,
                            List<Integer> path, Set<Integer> visited, List<List<Integer>> allRoutes) {
        path.add(current);
        visited.add(current);

        if (current == target) {
            allRoutes.add(new ArrayList<>(path));
        } else {
            for (int next : roads.getOrDefault(current, List.of())) {
                if (!visited.contains(next)) {
                    dfs(roads, next, target, path, visited, allRoutes);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> roads = Map.of(
            1, List.of(2, 3),
            2, List.of(4),
            3, List.of(4, 5),
            4, List.of(6),
            5, List.of(6)
        );

        System.out.println(allRoutes(roads, 1, 6));
    }
}
