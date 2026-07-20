public class PlaylistTrackInsertion {
    static class Node {
        int trackId;
        Node next;

        Node(int trackId) {
            this.trackId = trackId;
        }
    }

    public static void main(String[] args) {
        Node track1 = new Node(101);
        Node track2 = new Node(102);
        Node track3 = new Node(103);
        track1.next = track2;
        track2.next = track3;

        insertAfter(track1, 999);

        printQueue(track1);
    }

    public static void insertAfter(Node current, int trackId) {
        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
    }

    public static void printQueue(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.trackId + " ");
            temp = temp.next;
        }
    }
}
