package com.ayush.article.a1.repo;

import com.ayush.article.a1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
