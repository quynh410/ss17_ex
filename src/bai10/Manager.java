package bai10;


import java.util.HashSet;
import java.util.Set;

public class Manager {
    private Set<Contact> contacts = new HashSet<>();

    public boolean addContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        if (contacts.contains(newContact)) {
            System.out.println("Error: Phone number already exists!");
            return false;
        }
        return contacts.add(newContact);
    }

    public boolean removeContact(String phoneNumber) {
        return contacts.removeIf(contact -> contact.getPhoneNumber().equals(phoneNumber));
    }

    public Contact findContact(String phoneNumber) {
        return contacts.stream()
                .filter(contact -> contact.getPhoneNumber().equals(phoneNumber))
                .findFirst()
                .orElse(null);
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            contacts.forEach(System.out::println);
        }
    }
}
