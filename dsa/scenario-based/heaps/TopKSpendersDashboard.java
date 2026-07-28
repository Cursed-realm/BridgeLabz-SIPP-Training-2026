import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TopKSpendersDashboard {
    public static void main(String[] args) {
        int[] transactions = {450, 1200, 300, 750, 2200, 1800, 600};
        int k = 3;
        List<Integer> topSpenders = topKLargest(transactions, k);
        System.out.println("Top " + k + " spending totals:");
        System.out.println(topSpenders);
    }

    public static List<Integer> topKLargest(int[] transactions, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int amount : transactions) {
            if (minHeap.size() < k) {
                minHeap.offer(amount);
            } else if (amount > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(amount);
            }
        }
        List<Integer> result = new ArrayList<>(minHeap);
        result.sort(Collections.reverseOrder());
        return result;
    }
}
