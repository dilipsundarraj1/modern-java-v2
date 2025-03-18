package com.modernjava.patternmatching.recordmatch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalServiceTest {

    AnimalService animalService = new AnimalService();

    @ParameterizedTest()
    @MethodSource("input")
    void retrieveName(Animal animal, String expectedResult) {
        var name = animalService.retrieveName(animal);
        assertEquals(expectedResult, name);
    }

    @ParameterizedTest()
    @MethodSource("inputWithNull")
    void retrieveNameV2(Animal animal, String expectedResult) {
        var name = animalService.retrieveNameV2(animal);
        assertEquals(expectedResult, name);
    }

    @ParameterizedTest()
    @MethodSource("inputWithNull")
    void retrieveNameGuardedPattern(Animal animal, String expectedResult) {
        var name = animalService.retrieveNameGuardedPattern(animal);
        assertEquals(expectedResult, name);
    }


    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(new Cat("Kitty", "Black"), "Kitty"),
                Arguments.of(new Dog("Scooby", "Black"), "Scooby"),
                Arguments.of(null, "")
        );
    }

    private static Stream<Arguments> inputWithNull() {
        return Stream.of(
                Arguments.of(new Cat("Kitty", "Black"), "Kitty"),
                Arguments.of(new Cat(null, "Black"), ""),
                Arguments.of(new Dog("Scooby", "Black"), "Scooby"),
                Arguments.of(null, "")
        );
    }
}