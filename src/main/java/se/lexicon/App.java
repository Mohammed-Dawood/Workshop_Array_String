package se.lexicon;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Current repository size: " + NameRepository.getSize());

        while (true) {
            System.out.println("\nDo you want to:\n1. Add a name\n2. Find a name\n3. Update a name\n4. Remove a name\n5. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addNames();
                    break;
                case "2":
                    findNames();
                    break;
                case "3":
                    updateName();
                    break;
                case "4":
                    removeName();
                    break;
                case "5":
                    System.out.println("All names: " + Arrays.toString(NameRepository.findAll()));
                    System.out.println("Clearing...");
                    NameRepository.clear();
                    System.out.println("Repository cleared. Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, 4, or 5.");
                    break;
            }
        }
    }

    private static void addNames() {
        while (true) {
            System.out.print("Enter name to add ('quit' to finish adding): ");
            String inputName = scanner.nextLine().trim();

            if (inputName.equalsIgnoreCase("quit")) {
                break;
            }

            if (isValidName(inputName)) {
                boolean added = NameRepository.add(inputName);
                if (added) {
                    System.out.println("'" + inputName + "' added successfully.");
                    System.out.println("All names: " + Arrays.toString(NameRepository.findAll()));
                } else {
                    System.out.println("'" + inputName + "' already exists. Choose a different name.");
                }
            } else {
                System.out.println("Invalid format. Must enter [first name][whitespace][last name].");
            }
        }
    }

    private static boolean isValidName(String name) {
        String[] parts = name.split(" ");
        return parts.length == 2;
    }

    private static void findNames() {
        while (true) {
            System.out.println("\nDo you want to find by:\n1. First name\n2. Last name\n3. Full name\n4. Go back to main menu");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    findByFirstName();
                    break;
                case "2":
                    findByLastName();
                    break;
                case "3":
                    findByFullName();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
                    break;
            }
        }
    }

    private static void updateName() {
        while (true) {
            System.out.print("Enter name to update ('quit' to go back): ");
            String originalName = scanner.nextLine().trim();

            if (originalName.equalsIgnoreCase("quit")) {
                break;
            }

            String foundName = NameRepository.find(originalName);
            if (foundName != null) {
                System.out.print("Enter updated name: ");
                String updatedName = scanner.nextLine().trim();

                if (isValidName(updatedName)) {
                    boolean updated = NameRepository.update(originalName, updatedName);
                    if (updated) {
                        System.out.println("Name updated successfully.");
                        System.out.println("All names: " + Arrays.toString(NameRepository.findAll()));
                    } else {
                        System.out.println("Failed to update name. Updated name already exists or original name not found.");
                    }
                } else {
                    System.out.println("Invalid format. Must enter [first name][whitespace][last name].");
                }
            } else {
                System.out.println("Name not found.");
            }
        }
    }

    private static void removeName() {
        while (true) {
            System.out.print("Enter name to remove ('quit' to go back): ");
            String fullName = scanner.nextLine().trim();

            if (fullName.equalsIgnoreCase("quit")) {
                break;
            }

            boolean removed = NameRepository.remove(fullName);
            if (removed) {
                System.out.println("'" + fullName + "' removed successfully.");
                System.out.println("All names: " + Arrays.toString(NameRepository.findAll()));
            } else {
                System.out.println("Failed to remove '" + fullName + "'. Name not found.");
            }
        }
    }

    private static void findByFirstName() {
        System.out.print("Enter first name to search: ");
        String firstName = scanner.nextLine().trim();
        String[] results = NameRepository.findByFirstName(firstName);
        System.out.println("Found: " + Arrays.toString(results));
    }

    private static void findByLastName() {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine().trim();
        String[] results = NameRepository.findByLastName(lastName);
        System.out.println("Found: " + Arrays.toString(results));
    }

    private static void findByFullName() {
        System.out.print("Enter full name to search: ");
        String fullName = scanner.nextLine().trim();
        String[] results = NameRepository.findByFullName(fullName);
        System.out.println("Found: " + Arrays.toString(results));
    }
}
