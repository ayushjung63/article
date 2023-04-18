package com.ayush.article.initializingbean.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentPojo implements InitializingBean {
    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("------------Property Set---------------");
        if (name!=null) {
            System.out.println(name);
        }
    }
}
