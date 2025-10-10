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


    private static Integer getInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("Failed to parse: " + s);
            return null;
        }
    }

}

