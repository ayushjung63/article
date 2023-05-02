package com.ayush.article.functionexception.controller;

import com.ayush.article.a1.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/function")
@RequiredArgsConstructor
public class FunctionController {
    private final StudentRepo studentRepo;

    @GetMapping("/num1/{num1}/num2/{num2}")
    public ResponseEntity divide(@PathVariable("num1") int num1,@PathVariable("num2") int num2){
        int result = studentRepo.divide(num1, num2);
        return ResponseEntity.ok(result);
    }
}
