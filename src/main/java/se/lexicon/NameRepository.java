package se.lexicon;

import java.util.Arrays;

public class NameRepository {

    private static String[] names = new String[0];

    // Returns the number of elements in the array
    public static int getSize() {
        return names.length;
    }

    // Sets the names array to the given array, replacing all existing names
    public static void setNames(String[] newNames) {
        names = newNames;
    }

    // Empties the names array
    public static void clear() {
        names = new String[0];
    }

    // Returns all names in a new array
    public static String[] findAll() {
        return Arrays.copyOf(names, names.length);
    }
}
