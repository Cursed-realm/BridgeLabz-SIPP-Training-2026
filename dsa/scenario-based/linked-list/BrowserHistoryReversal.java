public class BrowserHistoryReversal {
    static class Node {
        int pageId;
        Node next;

        Node(int pageId) {
            this.pageId = pageId;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head = reverseHistory(head);

        printHistory(head);
    }

    public static Node reverseHistory(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printHistory(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.pageId + " ");
            temp = temp.next;
        }
    }
}
