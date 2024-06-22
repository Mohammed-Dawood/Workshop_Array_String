package se.lexicon;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial size
        System.out.println("Initial size: " + NameRepository.getSize());

        // Loop to handle adding and finding names
        while (true) {
            // Add names dynamically
            while (true) {
                System.out.print("\nEnter name to add ('quit' to finish adding): ");
                String inputName = scanner.nextLine().trim();

                if (inputName.equalsIgnoreCase("quit")) {
                    break;
                }

                boolean added = NameRepository.add(inputName);
                if (added) {
                    System.out.println("'" + inputName + "' added successfully.");
                    // Print all names after each addition
                    System.out.println("All names: " + Arrays.toString(NameRepository.findAll()));
                }
            }

            // Find names dynamically
            while (true) {
                System.out.print("\nEnter name to find ('quit' to finish finding): ");
                String inputName = scanner.nextLine().trim();

                if (inputName.equalsIgnoreCase("quit")) {
                    break;
                }

                String foundName = NameRepository.find(inputName);
                if (foundName != null) {
                    System.out.println("'" + inputName + "' found in the repository as '" + foundName + "'.");
                } else {
                    System.out.println("'" + inputName + "' not found in the repository.");
                }
            }

            // Prompt to quit or continue
            System.out.print("\nDo you want to add more names or find more names? (add/find/quit): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("quit")) {
                break;
            } else if (!response.equals("add") && !response.equals("find")) {
                System.out.println("Invalid input. Please enter 'add', 'find', or 'quit'.");
            }
        }

        // Print all names after finishing
        System.out.println("\nFinal All names: " + Arrays.toString(NameRepository.findAll()));

        // Clear names
        NameRepository.clear();
        System.out.println("\nSize after clearing: " + NameRepository.getSize());

        scanner.close();
    }
}
