package com.ayush.article;

import com.ayush.article.configproperty.StudentProperties;
import com.ayush.article.initializingbean.pojo.StudentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({StudentProperties.class})
@SpringBootApplication
public class ArticleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

	@Autowired
	StudentProperties studentProperties;

	@Override
	public void run(String... args) {
		/*
		 * Initializing Bean
		 * */
		StudentPojo studentPojo=new StudentPojo();
		System.out.println("Setting student Name");
		studentPojo.setName("Ayush");

		System.out.println("-------------- Initialize Student Project----------------------");
		System.out.println(studentProperties.getName());
		System.out.println(studentProperties.getDepartment());
		System.out.println(studentProperties.getProject());
	}
}
