package com.ayush.article.a1.service.impl;

import com.ayush.article.a1.model.Student;
import com.ayush.article.a1.repo.StudentRepo;
import com.ayush.article.a1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl  implements StudentService {
    private final StudentRepo studentRepo;

    @Override
    public void save(Student student) {
         studentRepo.save(student);
    }


    @Override
    public Student getStudent(Integer id) {
        Student student = studentRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
        /*
        * Setting studentName here will not reflect any changed in DB
        * */
        student.setName("XYZ");
        return student;
    }

    @Transactional
    @Override
    public Student getStudentV2(Integer id) {
        Student student = studentRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
        /*
         * Setting studentName here will reflect change in DB
         * The name of student will be set XYZ even though save() method is not called.
         * */
        student.setName("John Doe Changed");
        return student;
    }
}
