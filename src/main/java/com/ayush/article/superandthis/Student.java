package com.ayush.article.superandthis;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Student extends User {
    private String faculty;

    public Student(Integer id,String name, String faculty){
        super(id,name);
        this.faculty=faculty;
    }

    public Student() {
       this(1,"John Doe","Computer Science");
    }

    @Override
    public String toString() {
        return String.format("Student[ id: %d, name : %s, faculty: %s]",this.getId(),this.getName(),this.getFaculty());
    }
}
