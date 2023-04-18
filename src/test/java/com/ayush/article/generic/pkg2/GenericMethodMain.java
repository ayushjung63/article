package com.ayush.article.generic.pkg2;

public class GenericMethodMain {
    public static void main(String[] args) {
        getData("String Return Type Method");
        getData(1);
    }
    public static  <T> void getData(T t){
        System.out.println(t);
    }
}
