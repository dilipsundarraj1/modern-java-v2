package com.learnJava.lambda;

import com.learnJava.data.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExceptionHandlingExample {

    static Consumer<Student> studentConsumer = (s) ->{
        try{
            System.out.println(s.getName().toUpperCase());
        }catch (Exception e){
            System.err.println("Exception is studentConsumer : " + e);
        }

    };

    static Consumer<Student> printNameInUpperCase(Consumer<Student> consumer){

        return name -> {
            try{
                consumer.accept(name);
            }catch (Exception e){
                System.err.println("Exception is printNameInUpperCase : " + e);
            }
        };
    }

    public static void main(String[] args) {

        List<Student> studentList= new ArrayList<>();
        studentList.add(new Student());
        studentList.forEach(studentConsumer);
        studentList.forEach(printNameInUpperCase((student) -> System.out.println(student.getName().toUpperCase())));

    }
}
