import java.util.PriorityQueue;

public class EmergencyRoomTriageQueue {
    private static class Patient {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        @Override
        public String toString() {
            return name + " (severity=" + severity + ")";
        }
    }

    private final PriorityQueue<Patient> triageQueue;

    public EmergencyRoomTriageQueue() {
        triageQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.severity, a.severity));
    }

    public void addPatient(String name, int severity) {
        triageQueue.offer(new Patient(name, severity));
    }

    public Patient treatNext() {
        return triageQueue.poll();
    }

    public Patient peekNext() {
        return triageQueue.peek();
    }

    public static void main(String[] args) {
        EmergencyRoomTriageQueue er = new EmergencyRoomTriageQueue();
        er.addPatient("Alice", 70);
        er.addPatient("Charlie", 95);
        er.addPatient("Bob", 80);

        System.out.println("Next to treat: " + er.peekNext());
        while (true) {
            Patient next = er.treatNext();
            if (next == null) {
                break;
            }
            System.out.println("Treating: " + next);
        }
    }
}
