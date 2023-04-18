package com.ayush.article.a1.controller;

import com.ayush.article.a1.model.Student;
import com.ayush.article.a1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping("v1/{id}")
    public Student fetchStudentV1(@PathVariable("id") Integer id){
        return studentService.getStudent(id);
    }

    @GetMapping("v2/{id}")
    public Student fetchStudentV2(@PathVariable("id") Integer id){
        return studentService.getStudentV2(id);
    }
}
