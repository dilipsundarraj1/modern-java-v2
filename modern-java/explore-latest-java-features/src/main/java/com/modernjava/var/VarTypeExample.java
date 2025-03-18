package com.modernjava.var;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VarTypeExample {

    //Defining the generics type on the right side is not needed.
    List<Integer> empty = Collections.<Integer>emptyList();

    //recommended to reduce verbosity
    List<Integer> empty1 = Collections.emptyList();


    //diamond syntax -> You don't have to define the whole type declaration in right side.
    Map<Integer, Map<String, String>> usersLists =
            new HashMap<Integer, Map<String, String>>();


    //var in the class properties are not allowed.
    //private var x = "abc";



    public static void main(String[] args) {

        var list = Collections.<Integer>emptyList();





        //inlay hints for showing types.

        List<String> names1 = List.of("adam", "dilip");

        var names = List.of("adam", "dilip");

        System.out.println("names = " + names);
        
        for(var name : names){
            System.out.println("name = " + name);
        }


        var  map1
                = Map.ofEntries(Map.entry("a", List.of("adam", "alex")));

        //var simplifies and makes the code less verbose
        Map<String, List<String >>  map = Map.ofEntries(Map.entry("a", List.of("adam", "alex")));

        for(var entry : map.entrySet()){
            System.out.println("name = " + entry);
        }

        map.forEach((var k, var v) ->
                System.out.println("k = " + k));

        map.forEach((k, v) ->
                System.out.println("k = " + k));

        var transformedName = transform("dilip");
        System.out.println("transformedName = " + transformedName);

        //var is not a reserved keyword
        var var = "Java";


        /***
         * Limitations
         */
        //var x = null // This is not allowed because type cannot be infered.
        var s = "Hello, World";
        //s=3 // Changing the type is not allowed

    }

    static String transform(String name) { // var in the function argument is not allowed

        return name.toUpperCase();

    }

}

