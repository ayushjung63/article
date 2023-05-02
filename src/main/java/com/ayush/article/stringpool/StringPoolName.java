package com.ayush.article.stringpool;

public class StringPoolName {
    public static void main(String[] args) {
        String name = "John"; // get stored in String Pool
        String nam2 = new String("John"); // get stored outside of string pool in heap memory

        String john = "John"; // get referenced to the {name} object in spring pool
        System.out.println(name == john);

        /*
        using new Keyword save the string outside of string pool in heap memory
        but using intern() string literal get stored in string pool and referenced to exisiting if already exists
         */
        String name3 = new String("John").intern();
        System.out.println(name.equals(name3));


        /*
        * When you call intern() on a String object, it checks if the string is already present in the String Pool.
        * If the string is already in the String Pool, then intern() returns a reference to that string.
        *  If the string is not present in the String Pool, it adds the string to the pool and returns a reference to it.
           In your code, name is created using a string literal, so it is automatically added to the String Pool.
        * nam2 is created using the new keyword, so it is not automatically added to the String Pool.
        *  However, when you call nam2.intern(), it checks if the string "John" is already present in the String Pool.
        * Since name is already present in the String Pool, nam2.intern() returns a reference to the same string instance that name.intern() returns.
           Therefore, the comparison nam2.intern() == name.intern() returns true because both expressions return a reference
        *  to the same string instance in the String Pool.
        * */
        System.out.println(nam2.intern() == name.intern());
    }
}
