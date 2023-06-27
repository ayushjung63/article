package com.ayush.article.onetomany.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id")
    private College college;

    public Students(String name, College college) {
        this.name=name;
        this.college=college;
    }

    public Students() {
    }
}
