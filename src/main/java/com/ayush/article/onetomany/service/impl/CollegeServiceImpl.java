package com.ayush.article.onetomany.service.impl;

import com.ayush.article.onetomany.model.College;
import com.ayush.article.onetomany.model.Students;
import com.ayush.article.onetomany.pojos.CollegePojo;
import com.ayush.article.onetomany.repo.CollegeRepo;
import com.ayush.article.onetomany.service.CollegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollegeServiceImpl implements CollegeService {
    private final CollegeRepo collegeRepo;

    @Override
    public Integer save(CollegePojo collegePojo) {
        College college;
        if (collegePojo.getId()!=null){
            college=collegeRepo.findById(collegePojo.getId()).get();
        }else{
            college=new College();
        }
        college.setName(collegePojo.getName());
        college.getStudentsList().clear();
        List<Students> studentsList =new ArrayList<>();
        collegePojo.getStudentPojoList().stream().forEach(x->{
            Students students = new Students(x.getName(), college);
            studentsList.add(students);
        });
        college.getStudentsList().addAll(studentsList);
        collegeRepo.save(college);
        return college.getId();
    }
}
