package com.modernjava.patternmatching.recordmatch;

public class AnimalService {

    public String retrieveName(Animal animal) {
        return switch (animal) {
            case null -> ""; // This handles the null pointer exception.
            case Cat cat -> cat.name();
            case Dog dog -> dog.name();
        };

    }

    public String retrieveNameV2(Animal animal) {
        return switch (animal) {
//            case Car(String name,
//                     String color) -> name;
            //type inference can also be used in the binding variable.
            //case Cat(var name, var color) -> name;
            case Cat(var name, var color) -> {
                //If there are many conditions or checks this case statement can bloat up.
                // guarded patterns is another option that's applicable to us.
                System.out.println("name : "+name);
                yield name==null ? "" : name;
            }
            case Dog(String name, String color) -> name;
            // The null case is must and it handles the null pointer exception.
            // It does not matter where this case statement is kept.
            case null -> "";
        };
    }

    public String retrieveNameGuardedPattern(Animal animal) {
        return switch (animal) {
            case Cat(var name, var color) when name==null -> "";
            case Cat(var name, var color) -> name;
            case Dog(String name, String color) -> name;
            // The null case is must and it handles the null pointer exception.
            // It does not matter where this case statement is kept.
            case null-> "";
        };
    }
}
