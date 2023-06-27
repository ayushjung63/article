package com.ayush.article.staticdemo;

public class StaticMain {
    static {
        num=2;
    }

    private static int num;
    private int x=2;
    public static void main(String[] args) {
        System.out.println(num);

//        x=x+2; //cannot be accessed here
    }
}
