package com.ayush.article.autoboxing;

public class Main {

    public static void main(String[] args) {

        int primitive=12;
        Integer objectInteger= primitive;
        System.out.println(objectInteger);

        Integer num= 20;
        int convertedFromObject=num;
        System.out.println(convertedFromObject);

        int primitiveInt=10;
        acceptObjectType(primitiveInt);
    }

    public static void acceptObjectType(Integer objectInteger){
        System.out.println("Type of objectInteger : "+objectInteger.getClass());
        System.out.println("Primitive type is auto converted to Object");
    }
}
