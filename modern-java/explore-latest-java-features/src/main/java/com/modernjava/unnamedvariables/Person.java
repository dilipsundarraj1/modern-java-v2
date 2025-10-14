package com.modernjava.unnamedvariables;

/**
 * Helper record for demonstrating method references
 */
public record Person(String name, int age) {
    // Constructor for single parameter (name only)
    public Person(String name) {
        this(name, 0);
    }

    // Default constructor
    public Person() {
        this("Unknown", 0);
    }
}
