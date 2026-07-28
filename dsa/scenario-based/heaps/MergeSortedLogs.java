import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedLogs {
    private static class LogEntry {
        long timestamp;
        String message;
        String source;

        LogEntry(long timestamp, String source, String message) {
            this.timestamp = timestamp;
            this.source = source;
            this.message = message;
        }

        @Override
        public String toString() {
            return "[" + timestamp + "] " + source + ": " + message;
        }
    }

    private static class Node {
        int sourceIndex;
        int elementIndex;
        LogEntry entry;

        Node(int sourceIndex, int elementIndex, LogEntry entry) {
            this.sourceIndex = sourceIndex;
            this.elementIndex = elementIndex;
            this.entry = entry;
        }
    }

    public static List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a.entry.timestamp, b.entry.timestamp));
        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new Node(i, 0, sources.get(i).get(0)));
            }
        }

        List<LogEntry> merged = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Node top = minHeap.poll();
            merged.add(top.entry);
            int nextIndex = top.elementIndex + 1;
            if (nextIndex < sources.get(top.sourceIndex).size()) {
                minHeap.offer(new Node(top.sourceIndex, nextIndex, sources.get(top.sourceIndex).get(nextIndex)));
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        List<LogEntry> serverA = List.of(
            new LogEntry(1001, "ServerA", "Started"),
            new LogEntry(1005, "ServerA", "Received request"),
            new LogEntry(1010, "ServerA", "Completed task")
        );
        List<LogEntry> serverB = List.of(
            new LogEntry(1002, "ServerB", "Started"),
            new LogEntry(1006, "ServerB", "Error"),
            new LogEntry(1012, "ServerB", "Restarted")
        );
        List<List<LogEntry>> sources = List.of(serverA, serverB);

        List<LogEntry> mergedLogs = mergeKSortedLogs(sources);
        System.out.println("Merged log timeline:");
        for (LogEntry entry : mergedLogs) {
            System.out.println(entry);
        }
    }
}
