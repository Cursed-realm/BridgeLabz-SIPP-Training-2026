import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone must not be empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be empty");
        }
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return name + " | " + phone + " | " + email;
    }
}

public class AddressBookApp {
    private List<Contact> contacts;
    private Map<String, Contact> nameIndex;
    private Set<String> phoneNumbers;

    public AddressBookApp() {
        contacts = new ArrayList<Contact>();
        nameIndex = new HashMap<String, Contact>();
        phoneNumbers = new HashSet<String>();
    }

    public boolean addContact(String name, String phone, String email) {
        if (phoneNumbers.contains(phone)) {
            return false;
        }
        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        nameIndex.put(name, contact);
        phoneNumbers.add(phone);
        return true;
    }

    public Contact searchByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        return nameIndex.get(name);
    }

    public boolean deleteContact(String name) {
        Contact contact = nameIndex.get(name);
        if (contact == null) {
            return false;
        }
        contacts.remove(contact);
        nameIndex.remove(name);
        phoneNumbers.remove(contact.getPhone());
        return true;
    }

    public void displaySortedByName() {
        List<Contact> sortedContacts = new ArrayList<Contact>(contacts);
        Collections.sort(sortedContacts, new Comparator<Contact>() {
            public int compare(Contact first, Contact second) {
                return first.getName().compareTo(second.getName());
            }
        });
        for (Contact contact : sortedContacts) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        AddressBookApp addressBook = new AddressBookApp();

        addressBook.addContact("Zara", "9876543210", "zara@example.com");
        addressBook.addContact("Aditya", "9123456780", "aditya@example.com");
        addressBook.addContact("Manav", "9988776655", "manav@example.com");

        boolean duplicateAdded = addressBook.addContact("Fake", "9876543210", "fake@example.com");
        System.out.println("Duplicate phone add allowed: " + duplicateAdded);

        System.out.println("Search Aditya: " + addressBook.searchByName("Aditya"));

        System.out.println("Contacts sorted by name:");
        addressBook.displaySortedByName();

        addressBook.deleteContact("Manav");
        System.out.println("After deleting Manav:");
        addressBook.displaySortedByName();
    }
}
