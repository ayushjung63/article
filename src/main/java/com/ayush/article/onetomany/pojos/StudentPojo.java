package com.ayush.article.onetomany.pojos;

import lombok.Data;

public class StudentPojo {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void read(){
        System.out.println("I am reading");
    }
}
