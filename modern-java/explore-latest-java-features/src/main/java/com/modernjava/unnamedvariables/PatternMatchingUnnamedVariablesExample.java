package com.modernjava.unnamedvariables;


import java.util.List;

/**
 * Demonstrates the use of unnamed variables (underscore _) in Java
 *
 * Unnamed variables allow you to explicitly indicate that you're not using
 * a variable, making your code more readable and intentional.
 *
 * This feature was introduced as a preview in Java 21 and became standard in Java 22.
 */
public class PatternMatchingUnnamedVariablesExample {

    public static void main(String[] args) {
        demonstrateUnnamedVariablesInPatternMatching();
    }


    /**
     * Example 3: Using unnamed variables in pattern matching (Java 21+)
     * When you need to match a pattern but don't need some of the extracted values
     */
    public static void demonstrateUnnamedVariablesInPatternMatching() {
        System.out.println("=== Unnamed Variables in Pattern Matching ===");

        var people = List.of(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35)
        );

        System.out.println("Extracting only names (ignoring age and city):");
        for (var person : people) {
            // In a real pattern matching scenario, you might use:
            // if (person instanceof Person(var name, var _, var _))
            // For now, we'll simulate the concept
            extractNameOnly(person);
        }

        System.out.println();
    }

    /**
     * Helper method to demonstrate the concept of ignoring certain values
     */
    private static void extractNameOnly(Object obj) {
        if (obj instanceof Person person) {
            // We only care about the name, not age or city
            var name = person.name();
            // In pattern matching, we would use unnamed variables for age and city
            System.out.println("Person name: " + name);
        }
    }


    /**
     * Example 4: Comparison between traditional and unnamed variable approaches
     */
    public static void demonstrateComparison() {
        System.out.println("=== Comparison: Traditional vs Unnamed Variables ===");

        // Traditional approach - exception variable declared but not used
        try {
            Integer.parseInt("not a number");
        } catch (NumberFormatException e) {
            // 'e' is declared but never used - this might generate warnings
            System.out.println("Traditional: Exception occurred but not using exception details");
        }

        // Unnamed variable approach - explicitly showing we don't need the exception
        try {
            Integer.parseInt("not a number");
        } catch (NumberFormatException _) {
            // Using _ explicitly shows we intentionally don't need the exception object
            System.out.println("Unnamed variable: Exception occurred, intentionally ignoring details");
        }

        System.out.println();
    }
}
