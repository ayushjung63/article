package com.ayush.article.reverse;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class College {
    private int id;
    private String name;
    private Collection<Students> studentsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        College college = (College) o;
        return id == college.id &&
                Objects.equals(name, college.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "collegeByCollegeId")
    public Collection<Students> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<Students> studentsById) {
        this.studentsById = studentsById;
    }
}
