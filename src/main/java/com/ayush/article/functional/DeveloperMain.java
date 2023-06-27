package com.ayush.article.functional;

public class DeveloperMain {
    public static void main(String[] args) {
        DeveloperInterface developerInterface=()-> System.out.println("I code in Java");
        developerInterface.code();
    }
}
