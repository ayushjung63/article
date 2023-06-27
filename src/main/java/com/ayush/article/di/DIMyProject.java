package com.ayush.article.di;

public class DIMyProject {
    private Programmer programmer;

    public DIMyProject(Programmer programmer) {
        this.programmer = programmer;
    }

    public void develop(){
        programmer.code();
    }
}
