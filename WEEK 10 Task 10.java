import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> contacts = new HashMap<>();

        System.out.print("Enter number of contacts: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Store contacts
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter phone number: ");
            String phone = sc.nextLine();

            contacts.put(name, phone);
        }

        // Search contact
        System.out.print("\nEnter name to search: ");
        String searchName = sc.nextLine();

        if (contacts.containsKey(searchName)) {
            System.out.println("Phone Number: " + contacts.get(searchName));
        } else {
            System.out.println("Contact not found.");
        }

        // Update contact
        System.out.print("\nEnter name to update: ");
        String updateName = sc.nextLine();

        if (contacts.containsKey(updateName)) {
            System.out.print("Enter new phone number: ");
            String newPhone = sc.nextLine();

            contacts.put(updateName, newPhone);

            System.out.println("Contact updated successfully.");
            System.out.println("Updated Number: " + contacts.get(updateName));
        } else {
            System.out.println("Contact not found.");
        }
    }
}
