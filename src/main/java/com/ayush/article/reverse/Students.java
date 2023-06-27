package com.ayush.article.reverse;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Students {
    private int id;
    private String name;
    private Integer collegeId;
    private College collegeByCollegeId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "college_id")
    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id &&
                Objects.equals(name, students.name) &&
                Objects.equals(collegeId, students.collegeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, collegeId);
    }

    @ManyToOne
    @JoinColumn(name = "college_id", referencedColumnName = "id")
    public College getCollegeByCollegeId() {
        return collegeByCollegeId;
    }

    public void setCollegeByCollegeId(College collegeByCollegeId) {
        this.collegeByCollegeId = collegeByCollegeId;
    }
}
