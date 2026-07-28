import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FriendGraphRepresentation {
    private final Map<Integer, Set<Integer>> friendGraph = new HashMap<>();

    public void addFriendship(int u, int v) {
        friendGraph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        friendGraph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }

    public boolean isFriend(int u, int v) {
        return friendGraph.getOrDefault(u, Collections.emptySet()).contains(v);
    }

    public static void main(String[] args) {
        FriendGraphRepresentation graph = new FriendGraphRepresentation();
        graph.addFriendship(1, 2);
        graph.addFriendship(1, 3);
        graph.addFriendship(4, 5);

        System.out.println("1 and 2 are friends: " + graph.isFriend(1, 2));
        System.out.println("2 and 4 are friends: " + graph.isFriend(2, 4));
    }
}
