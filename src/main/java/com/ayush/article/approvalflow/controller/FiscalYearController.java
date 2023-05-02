package com.ayush.article.approvalflow.controller;

import com.ayush.article.a1.model.Student;
import com.ayush.article.approvalflow.entity.FiscalYear;
import com.ayush.article.approvalflow.service.FiscalYearService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fiscal-year")
@RequiredArgsConstructor
public class FiscalYearController {
    private final FiscalYearService fiscalYearService;

    @PostMapping
    public void save(@RequestBody FiscalYear fiscalYear){
        fiscalYearService.create(fiscalYear);
    }

    @GetMapping("/forward/{id}")
    public void forward(@PathVariable("id") Long id){
        fiscalYearService.forward(id);
    }

    @GetMapping("/backward/{id}")
    public void backward(@PathVariable("id") Long id){
        fiscalYearService.reject(id);
    }

}
