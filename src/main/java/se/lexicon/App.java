package se.lexicon;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Test the NameRepository class

        // Initial size
        System.out.println("Initial size: " + NameRepository.getSize());

        // Set names
        String[] newNames = {"Erik Svensson", "Anna Andersson", "John Doe"};
        NameRepository.setNames(newNames);
        System.out.println("Size after setting names: " + NameRepository.getSize());

        // Find all names
        System.out.println("All names: " + Arrays.toString(NameRepository.findAll()));

        // Clear names
        NameRepository.clear();
        System.out.println("Size after clearing: " + NameRepository.getSize());
    }
}