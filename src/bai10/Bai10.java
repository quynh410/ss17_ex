package bai10;

import java.util.Scanner;

public class Bai10 {
    public class Main {
        public static void main(String[] args) {
            Manager manager = new Manager();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nContact Manager Menu:");
                System.out.println("1. Add Contact");
                System.out.println("2. Remove Contact");
                System.out.println("3. Find Contact");
                System.out.println("4. Display Contacts");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter phone number: ");
                        String phone = scanner.nextLine();
                        manager.addContact(name, phone);
                        break;
                    case 2:
                        System.out.print("Enter phone number to remove: ");
                        String removePhone = scanner.nextLine();
                        if (manager.removeContact(removePhone)) {
                            System.out.println("Contact removed.");
                        } else {
                            System.out.println("Contact not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter phone number to search: ");
                        String searchPhone = scanner.nextLine();
                        Contact found = manager.findContact(searchPhone);
                        System.out.println(found != null ? found : "Contact not found.");
                        break;
                    case 4:
                        manager.displayContacts();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
    }

}
