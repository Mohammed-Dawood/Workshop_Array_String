package se.lexicon;

import java.util.Arrays;

public class NameRepository {
    private static String[] names = new String[0];

    // Returns the number of elements in the array
    public static int getSize() {
        return names.length;
    }

    // Empties the names array
    public static void clear() {
        names = new String[0];
    }

    // Returns all names in a new array
    public static String[] findAll() {
        return Arrays.copyOf(names, names.length);
    }

    // Returns name if found and null if not found
    public static String find(final String fullName) {
        for (String name : names) {
            if (name.equalsIgnoreCase(fullName)) {
                return name;
            }
        }
        return null; // Not found
    }

    // Adds a new name to the array in the format "first name][whitespace][last name". Returns true if added, false if already exists
    public static boolean add(final String fullName) {
        // Split the fullName into first name and last name
        String[] parts = fullName.split("\\s+");
        if (parts.length != 2) {
            System.out.println("Invalid format. Please enter first name and last name separated by whitespace.");
            return false;
        }

        // Concatenate and add to names array
        String firstName = parts[0];
        String lastName = parts[1];
        String fullNameFormatted = firstName + " " + lastName;

        if (find(fullNameFormatted) != null) {
            System.out.println("'" + fullNameFormatted + "' already exists in the repository.");
            return false; // Name already exists
        }

        // Create a new array with increased size
        String[] newNames = Arrays.copyOf(names, names.length + 1);
        newNames[newNames.length - 1] = fullNameFormatted; // Add new name at the end
        names = newNames; // Update names array

        return true;
    }
}
