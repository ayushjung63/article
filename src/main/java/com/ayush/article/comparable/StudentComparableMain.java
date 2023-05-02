package com.ayush.article.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentComparableMain {
    public static void main(String[] args) {
        Student student=new Student(1,"Ayush Basnet","Java");
        Student student2=new Student(3,"Ayush Basnet","Java");
        Student student3=new Student(2,"Ayush Basnet","Java");
        List<Student> students = Arrays.asList(student, student2,student3);
        System.out.println(students);

        Collections.sort(students);
        System.out.println(students);
    }
}
