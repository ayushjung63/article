package com.ayush.article.di.impl;

import com.ayush.article.di.Programmer;

public class JavaProgrammer  implements Programmer {
    @Override
    public void code() {
        System.out.println("I code in Java");
    }
}
