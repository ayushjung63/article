package com.ayush.article.onetomany.repo;

import com.ayush.article.onetomany.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepo extends JpaRepository<College,Integer> {
}
