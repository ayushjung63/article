package com.ayush.article.generic.bounded;

public class GenericUser<T extends User> {
    public void login(){
        System.out.println("Login");
    }
}
