package com.ayush.article.a1.repo;

import com.ayush.article.a1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Query(
            nativeQuery=true,
            value="\n" +
                    "select divide(?1,?2)  "
    )
    int divide(int num1,int num2);
}
