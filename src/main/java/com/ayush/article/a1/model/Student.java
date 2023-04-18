package com.ayush.article.a1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @SequenceGenerator(name = "student_seq",sequenceName = "student_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    private Integer id;

    private String name;

    private String faculty;
}
