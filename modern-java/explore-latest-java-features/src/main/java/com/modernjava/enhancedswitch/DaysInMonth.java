package com.modernjava.enhancedswitch;

import java.time.Month;
import java.time.Year;

public class DaysInMonth {
    public static int getDaysV2(Month month, int year) {
        return switch (month) {
            case SEPTEMBER, APRIL, JUNE, NOVEMBER -> 30;
             case FEBRUARY -> Year.isLeap(year) ? 29 : 28;
//            case FEBRUARY -> { // this is a code block;
//                System.out.println("Checking if " + year + " is a leap year");
//                yield Year.isLeap(year) ? 29 : 28;
//                //yield is used to return from the switch expression.
//            }
            //case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
            default -> 31;
        };
    }

    public static int getDaysV3(Month month, int year) {
        return  switch (month) {
            case SEPTEMBER, APRIL, JUNE, NOVEMBER -> 30;
            case FEBRUARY -> { // this is a code block;
                System.out.println("Checking if " + year + " is a leap year");
                yield Year.isLeap(year) ? 29 : 28;
            }
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER-> 31;
        };
    }

    public static int getDays(Month month, int year) {
        int noOfDays = 0;
        switch (month) {
            case SEPTEMBER:
            case APRIL:
            case JUNE:
            case NOVEMBER:
                noOfDays = 30;
                //return noOfDays;
                break;
            case FEBRUARY: // this is a code block;
                System.out.println("Checking if " + year + " is a leap year");
                noOfDays = Year.isLeap(year) ? 29 : 28;
                //  return noOfDays;
                break;

            default:
                noOfDays = 31;
        }
        return noOfDays;

    }
}
