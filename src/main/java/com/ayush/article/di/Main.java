package com.ayush.article.di;

import com.ayush.article.di.impl.JavaProgrammer;
import com.ayush.article.di.impl.PythonProgrammer;


public class Main {
    public static void main(String[] args) {
        MyProject myProject=new MyProject();
        myProject.develop();

        /* can switch depedency class as per choice*/
        DIMyProject javaProject=new DIMyProject(new JavaProgrammer());
        DIMyProject pythonProject=new DIMyProject(new PythonProgrammer());
        javaProject.develop();
        pythonProject.develop();

        DIMyProject jsProject=new DIMyProject(()-> System.out.println("I code in JS"));
        jsProject.develop();
    }
}
