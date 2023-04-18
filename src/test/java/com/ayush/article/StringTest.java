package com.ayush.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StringTest {
    private String empName;
    private Integer id;

    public StringTest(String empName, Integer id) {
        this.empName = empName;
        this.id = id;
    }
}
