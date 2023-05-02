package com.ayush.article.superandthis;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private String courseCode;
    private String courseName;
    private String courseFullTitle;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.concat(this);
//        this.concat();
    }

    public void concat(Course course){
        course.setCourseFullTitle(courseCode.concat(" "+courseName));
    }
    public void concat(){
        this.setCourseFullTitle(courseCode.concat(" "+courseName));
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseFullTitle='" + courseFullTitle + '\'' +
                '}';
    }
}
