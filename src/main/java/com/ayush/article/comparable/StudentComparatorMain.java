package com.ayush.article.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentComparatorMain {
    public static void main(String[] args) {
        Student student=new Student(1,"Jane","Java");
        Student student2=new Student(2,"John","React");
        Student student3=new Student(3,"Mike","BA");
        List<Student> students = Arrays.asList(student, student2,student3);
        System.out.println(students);

        Collections.sort(students,new StudentDeptComparator());
        System.out.println(students);

        Collections.sort(students,new StudentNameComparator());
        System.out.println(students);

        Collections.sort(
                students,
                (s1,s2)->{
                    return s1.getDepartment().compareTo(s2.getDepartment());
                }
        );
        System.out.println(students);
    }
}
