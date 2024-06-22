package se.lexicon;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial size
        System.out.println("Initial size: " + NameRepository.getSize());

        // Add names dynamically
        while (true) {
            System.out.print("Enter name to add ('quit' to finish): ");
            String inputName = scanner.nextLine().trim();

            if (inputName.equalsIgnoreCase("quit")) {
                break;
            }

            boolean added = NameRepository.add(inputName);
            if (added) {
                System.out.println("'" + inputName + "' added successfully.");
            } else {
                System.out.println("'" + inputName + "' already exists in the repository.");
            }
        }

        // Find names dynamically
        System.out.println("\nEnter names to find ('quit' to finish):");
        while (true) {
            System.out.print("Enter name: ");
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

        // Print all names
        System.out.println("\nAll names: " + Arrays.toString(NameRepository.findAll()));

        // Clear names
        NameRepository.clear();
        System.out.println("\nSize after clearing: " + NameRepository.getSize());

        scanner.close();
    }
}
