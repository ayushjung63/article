package com.ayush.article.stringpool;

public class
StringPoolExample {
    public static void main(String[] args) {
        String name="John Doe"; // get created in String Pool inside Heap Memory
        String name2= "John Doe"; // // get referenced to the {name} object in spring pool
        System.out.println("Content Check: "+name.equals(name2)); //content check: returns true
        System.out.println("Reference Check: "+ name == name2); //reference check: returns true since they both point to same object in String Pool

        //get created in Heap Memory outside String Pool
        String name3= new String("John Doe");
        // this is also stored as new object in Heap Memory
        String name4=new String("John Doe");

        //content check: returns true
        System.out.println("Content Check: "+ name3.equals(name4));
        // returns false since their reference in Heap Memory is Different
        System.out.println("Reference Check "+name3 == name4);


        String hello=new String("Hello");
        System.out.println(hello.hashCode());
        System.out.println(System.identityHashCode(hello));

        String hello2="Hello";
        System.out.println(hello2.hashCode());
        System.out.println(System.identityHashCode(hello2));
    }
}
