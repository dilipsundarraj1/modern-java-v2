package com.modernjava.enhancedswitch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaysInMonthTest {

    @ParameterizedTest(name = "Checking days in {0}")
    @EnumSource(Month.class)
    void getDaysV2(Month month) {
        int days = DaysInMonth.getDaysV2(month, 2023);
        switch (month) {
            case FEBRUARY -> assertEquals(28, days);
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> assertEquals(30, days);
            default -> assertEquals(31, days);
        }
    }

    @ParameterizedTest(name = "Checking days in {0}")
    @EnumSource(Month.class)
    void getDaysV3(Month month) {
        int days = DaysInMonth.getDaysV3(month, 2023);
        switch (month) {
            case FEBRUARY -> assertEquals(28, days);
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> assertEquals(30, days);
            default -> assertEquals(31, days);
        }
    }


    @ParameterizedTest
    @MethodSource("input")
    void getDaysV2(Month month, int expectedNoOfDays) {
        int days = DaysInMonth.getDays(month, 2023);
        assertEquals(expectedNoOfDays, days);
    }

    @ParameterizedTest
    @MethodSource("input")
    void getDaysV3(Month month, int expectedNoOfDays) {
        int days = DaysInMonth.getDays(month, 2023);
        assertEquals(expectedNoOfDays, days);
    }

    @ParameterizedTest
    @MethodSource("input")
    void getDays(Month month, int expectedNoOfDays) {
        int days = DaysInMonth.getDays(month, 2023);
        assertEquals(expectedNoOfDays, days);
    }



    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(Month.FEBRUARY, 28),
                Arguments.of(Month.SEPTEMBER, 30),
                Arguments.of(Month.JANUARY, 31)
        );
    }
}