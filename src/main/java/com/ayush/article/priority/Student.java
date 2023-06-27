package com.ayush.article.priority;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private double cgpa;

    public Student(Integer id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
}
