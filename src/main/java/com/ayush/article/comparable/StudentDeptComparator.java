package com.ayush.article.comparable;

import java.util.Comparator;

class StudentDeptComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getDepartment().compareTo(s2.getDepartment());
    }
}