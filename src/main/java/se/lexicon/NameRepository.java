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

    // Adds a new name to the array. Returns true if added, false if already exists
    public static boolean add(final String fullName) {
        if (find(fullName) != null) {
            return false; // Name already exists
        }

        // Create a new array with increased size
        String[] newNames = Arrays.copyOf(names, names.length + 1);
        newNames[newNames.length - 1] = fullName; // Add new name at the end
        names = newNames; // Update names array

        return true;
    }
}
