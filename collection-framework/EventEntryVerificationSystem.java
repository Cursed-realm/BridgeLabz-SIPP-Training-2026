import java.util.HashSet;
import java.util.Set;

public class EventEntryVerificationSystem {
    private Set<String> registeredEmails;

    public EventEntryVerificationSystem() {
        registeredEmails = new HashSet<String>();
    }

    public boolean registerParticipant(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be empty");
        }
        return registeredEmails.add(email);
    }

    public void displayAllParticipants() {
        System.out.println("Registered Participants:");
        for (String email : registeredEmails) {
            System.out.println(email);
        }
    }

    public int getTotalAttendees() {
        return registeredEmails.size();
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem eventSystem = new EventEntryVerificationSystem();

        boolean first = eventSystem.registerParticipant("aditya@example.com");
        boolean second = eventSystem.registerParticipant("zara@example.com");
        boolean duplicate = eventSystem.registerParticipant("aditya@example.com");

        System.out.println("First registration success: " + first);
        System.out.println("Second registration success: " + second);
        System.out.println("Duplicate registration rejected: " + !duplicate);

        eventSystem.registerParticipant("manav@example.com");

        eventSystem.displayAllParticipants();
        System.out.println("Total attendees: " + eventSystem.getTotalAttendees());
    }
}
