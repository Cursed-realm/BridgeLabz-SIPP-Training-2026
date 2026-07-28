import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FewestConnectingFlights {
    public static List<Integer> fewestFlights(Map<Integer, List<Integer>> routes, int origin, int destination) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(origin);
        visited.add(origin);
        parent.put(origin, null);

        while (!queue.isEmpty()) {
            int city = queue.poll();
            if (city == destination) {
                break;
            }
            for (int next : routes.getOrDefault(city, List.of())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    parent.put(next, city);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(destination)) {
            return List.of();
        }

        Deque<Integer> path = new ArrayDeque<>();
        Integer current = destination;
        while (current != null) {
            path.addFirst(current);
            current = parent.get(current);
        }
        return new ArrayList<>(path);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> routes = new HashMap<>();
        routes.put(1, List.of(2, 3));
        routes.put(2, List.of(4));
        routes.put(3, List.of(4, 5));
        routes.put(4, List.of(6));

        System.out.println(fewestFlights(routes, 1, 6));
    }
}
