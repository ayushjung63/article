package com.ayush.article.onetomany.pojos;

import lombok.Data;

import java.util.List;

@Data
public class CollegePojo {
    private Integer id;
    private String name;
    private List<StudentPojo> studentPojoList;
}
