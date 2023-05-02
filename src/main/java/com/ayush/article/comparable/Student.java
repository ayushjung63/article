package com.ayush.article.comparable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student  implements Comparable<Student>{
    private Integer id;
    private String name;
    private String department;

    @Override
    public int compareTo(Student student) {
        int compare = this.name.compareTo(student.name);
        if (compare==0) {
            return this.id.compareTo(student.id);
        }
        return compare;
    }
}
