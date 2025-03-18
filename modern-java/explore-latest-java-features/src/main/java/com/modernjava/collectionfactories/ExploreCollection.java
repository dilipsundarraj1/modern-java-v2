package com.modernjava.collectionfactories;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

public class ExploreCollection {

    public static void main(String[] args) {

        var list = List.of(1,2, 3);
        System.out.println("list = " + list);

        var sampleMap = Map.of(1, "One", 2 , "2");
        System.out.println("sampleMap = " + sampleMap);

        var sampleMap1 = Map.ofEntries(entry(1, "One"), entry(2, "two"));

        System.out.println("sampleMap1 = " + sampleMap1);

        var set = Set.of("a", "b", "c");
        System.out.println("set = " + set);
    }
}
