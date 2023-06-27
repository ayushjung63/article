package com.ayush.article.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserMain {
    public static void main(String[] args) {
        User u1=new User(2,"B");
        User u2=new User(1,"D");
        User u3=new User(3,"C");
        List<User> users = Arrays.asList(u1, u2, u3);
        for (User u : users){
            System.out.println(u.getId()+" "+ u.getName());
        }
        System.out.println("----------------------------------");

        Collections.sort(users);
        for (User u : users){
            System.out.println(u.getId()+" "+ u.getName());
        }
        System.out.println("----------------------------------");
        Collections.sort(users,new NameComparator());
        for (User u : users){
            System.out.println(u.getId()+" "+ u.getName());
        }

    }
}
