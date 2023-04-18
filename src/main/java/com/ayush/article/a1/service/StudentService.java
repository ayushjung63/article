package com.ayush.article.a1.service;

import com.ayush.article.a1.model.Student;

public interface StudentService {
    void save(Student student);
    Student getStudent(Integer id);
    Student getStudentV2(Integer id);
}
