package com.ayush.article.generic.pkg1;

public class GenericClassMain {
    public static void main(String[] args) {
        GenericClass<Integer> integerGenericClass=new GenericClass(1);
        System.out.println(integerGenericClass.getData());

        GenericClass<String> stringGenericClass=new GenericClass("Hello World");
        System.out.println(stringGenericClass.getData());
    }
}
