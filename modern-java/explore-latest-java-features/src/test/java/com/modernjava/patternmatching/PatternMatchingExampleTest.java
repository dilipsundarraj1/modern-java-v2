package com.modernjava.patternmatching;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternMatchingExampleTest {

     PatternMatchingExample patternMatchingExample
             = new PatternMatchingExample();

    @ParameterizedTest
    @MethodSource("input")
    void patternMatchUsingInstanceOf(Object value, String expectedResult) {

        var output =  patternMatchingExample.patternMatchUsingInstanceOf(value);
        assertEquals(expectedResult, output);
    }

    @ParameterizedTest
    @MethodSource("input")
    void patternMatchingUsingSwitch(Object value, String expectedResult) {

        var output =  patternMatchingExample.patternMatchingUsingSwitch(value);
        assertEquals(expectedResult, output);
    }


    @Test
    void patternMatchingUsingSwitch_null() {

        var output =  patternMatchingExample.patternMatchingUsingSwitch(null);
        assertEquals("Not a String or Integer", output);
    }

    @ParameterizedTest
    @MethodSource("input")
    void pattern(Object value, String expectedResult) {

        var output =  patternMatchingExample.pattern(value);
        assertEquals(expectedResult, output);
    }



    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of("Dilip", "String of length:5"),
                Arguments.of(1, "Integer:1"),
                Arguments.of(null, "Not a String or Integer")
        );
    }

}