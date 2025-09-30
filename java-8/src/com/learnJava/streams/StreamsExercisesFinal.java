package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;
import com.learnJava.data.Bike;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsExercisesFinal {

    // Exercise 1: List of student names with GPA appended (e.g., "Jenny - 3.8")
    public static List<String> namesWithGpa(List<Student> students) {
        return students.stream()
                .map(student -> student.getName() + " - " + student.getGpa())
                .collect(Collectors.toList());
    }

    // Exercise 2: Set of all unique student activities
    public static Set<String> uniqueActivities(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getActivities().stream())
                .collect(Collectors.toSet());
    }

    // Exercise 3: Map of student name to number of activities
    public static Map<String, Integer> nameToActivityCount(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        student -> student.getActivities().size()
                ));
    }

    // Exercise 4: List of names of students with more than 2 notebooks
    public static List<String> namesWithMoreThanTwoNotebooks(List<Student> students) {
        return students.stream()
                .filter(student -> student.getNoteBooks() > 2)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    // Exercise 5: Map of student name to bike model (or "No Bike" if absent)
    public static Map<String, String> nameToBikeModel(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        student -> {
                            Bike bike = student.getBike().orElse(null);
                            return (bike != null && bike.getModel() != null) ? bike.getModel() : "No Bike";
                        }
                ));
    }

    // Exercise 6: List of student names whose GPA is above 3.5
    public static List<String> namesWithHighGpa(List<Student> students) {
        return students.stream()
                .filter(student -> student.getGpa() > 3.5)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> students = StudentDataBase.getAllStudents();
        System.out.println("Names with GPA: " + namesWithGpa(students));
        System.out.println("Unique Activities: " + uniqueActivities(students));
        System.out.println("Name to Activity Count: " + nameToActivityCount(students));
        System.out.println("Names with >2 Notebooks: " + namesWithMoreThanTwoNotebooks(students));
        System.out.println("Name to Bike Model: " + nameToBikeModel(students));
        System.out.println("Names with High GPA: " + namesWithHighGpa(students));
    }
}

