package com.modernjava.unnamedvariables;

import java.util.List;
import java.util.Map;

/**
 * Advanced examples of unnamed variables in Java
 * <p>
 * Shows best practices and various scenarios where unnamed variables
 * improve code readability and express intent clearly.
 */
public class UnnamedVariables {

    static void main(String[] args) {
        demonstrateLambdaWithUnnamed();
        demonstrateExceptionHandling();
    }

    /**
     * Slide 1 + 2: lambdas with unnamed parameters
     * - (value, _) -> we only care about the first parameter
     */
    private static void demonstrateLambdaWithUnnamed() {
        System.out.println("Slide 2: lambda parameters with unnamed variable");

        Map<String, Integer> freq = Map.of("a", 1, "b", 2, "c", 3);

        freq.forEach((k, _) -> System.out.println("key: " + k ));

    }

    /**
     * Using multiple unnamed variables in different contexts
     */
    public static void demonstrateExceptionHandling() {
        System.out.println("=== Multiple Unnamed Variables ===");

        // Nested try-catch with multiple exceptions we don't care about
        var operations = List.of("123", "divide", "10");

        var intList = operations.stream()
                .map(s -> getInteger(s))
//                .map(UnnamedVariables::getInteger)
                .toList();
        System.out.println("Parsed integers: " + intList);
    }




    private static Integer getInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception _) {
            System.out.println("Failed to parse: " + s);
            return null;
        }
    }

}
