package com.ayush.article.configproperty;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "student")
public class StudentProperties {
    private String name;
    private String department;
    private String project;
}
