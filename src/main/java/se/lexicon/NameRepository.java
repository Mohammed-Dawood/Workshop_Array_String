package se.lexicon;

import java.util.Arrays;

public class NameRepository {
    private static String[] names = new String[0];

    public static int getSize() {
        return names.length;
    }

    public static void clear() {
        names = new String[0];
    }

    public static String[] findAll() {
        return names;
    }

    public static String find(final String fullName) {
        for (String name : names) {
            if (name.equalsIgnoreCase(fullName)) {
                return name;
            }
        }
        return null;
    }

    public static boolean add(final String fullName) {
        if (find(fullName) != null) {
            return false;
        }
        names = Arrays.copyOf(names, names.length + 1);
        names[names.length - 1] = fullName;
        return true;
    }

    public static boolean update(final String original, final String updatedName) {
        if (find(original) != null && find(updatedName) == null) {
            for (int i = 0; i < names.length; i++) {
                if (names[i].equalsIgnoreCase(original)) {
                    names[i] = updatedName;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean remove(final String fullName) {
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(fullName)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false; // Name not found
        }
        String[] newArray = new String[names.length - 1];
        for (int i = 0, j = 0; i < names.length; i++) {
            if (i != index) {
                newArray[j++] = names[i];
            }
        }
        names = newArray;
        return true;
    }

    public static String[] findByFirstName(final String firstName) {
        return Arrays.stream(names)
                .filter(name -> name.split(" ")[0].equalsIgnoreCase(firstName))
                .toArray(String[]::new);
    }

    public static String[] findByLastName(final String lastName) {
        return Arrays.stream(names)
                .filter(name -> name.split(" ")[1].equalsIgnoreCase(lastName))
                .toArray(String[]::new);
    }

    public static String[] findByFullName(final String fullName) {
        return Arrays.stream(names)
                .filter(name -> name.equalsIgnoreCase(fullName))
                .toArray(String[]::new);
    }
}
