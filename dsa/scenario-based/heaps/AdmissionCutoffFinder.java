import java.util.PriorityQueue;

public class AdmissionCutoffFinder {
    public static void main(String[] args) {
        int[] scores = {92, 87, 99, 78, 84, 95, 90, 88};
        int k = 3;
        int cutoff = findKthLargest(scores, k);
        System.out.println("Admission cutoff for rank " + k + ": " + cutoff);
    }

    public static int findKthLargest(int[] scores, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int score : scores) {
            if (minHeap.size() < k) {
                minHeap.offer(score);
            } else if (score > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(score);
            }
        }
        return minHeap.peek();
    }
}
