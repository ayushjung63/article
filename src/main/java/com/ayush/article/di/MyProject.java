package com.ayush.article.di;

import com.ayush.article.di.impl.JavaProgrammer;

public class MyProject {
    private Programmer programmer=new JavaProgrammer();

    public void develop(){
        programmer.code();
    }
}
