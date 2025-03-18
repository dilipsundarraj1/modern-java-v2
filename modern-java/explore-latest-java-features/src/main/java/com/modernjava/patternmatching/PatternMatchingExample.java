package com.modernjava.patternmatching;

public class PatternMatchingExample {

    public String pattern(Object o) {
        if (o instanceof Integer) {
            var i = (Integer) o;
            return "Integer:" + i;
        }
        if (o instanceof String) {
            var i = (String) o;
            return "String of length:" + i.length();
        }
        return "Not a String or Integer";

    }

    public String patternMatchUsingInstanceOf(Object o) {
        if (o instanceof Integer i) { // i is the binding variable.
            return "Integer:" + i;
        }
        if (o instanceof String i) {
            return "String of length:" + i.length();
        }
        return "Not a String or Integer";

    }

    public String patternMatchingUsingSwitch(Object o) {
        return switch (o) {
            //case String s -> "String of length:" + s.length();
            // guarded pattern
            // case String s && s.length() > 0 -> "String of length:" + s.length();
            case String s when s.length() > 0 -> "String of length:" + s.length();  // s is the binding variable.
            case Integer i -> "Integer:" + i;
            case Number i -> "Integer:" + i;
            //default -> "Not a String or Integer";
            case null, default -> "Not a String or Integer";
        };
    }

    public static void main(String[] args) {

        PatternMatchingExample patternMatchingExample = new PatternMatchingExample();
        patternMatchingExample.patternMatchUsingInstanceOf("abc");
        patternMatchingExample.patternMatchingUsingSwitch(null);
    }

}
