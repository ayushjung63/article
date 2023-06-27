package com.ayush.article.onetomany.controller;

import com.ayush.article.onetomany.pojos.CollegePojo;
import com.ayush.article.onetomany.service.CollegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/college")
public class CollegeController {
    private final CollegeService collegeService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CollegePojo collegePojo){
        Integer save = collegeService.save(collegePojo);
        return ResponseEntity.ok(save);
    }
}
