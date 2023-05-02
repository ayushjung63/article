package com.ayush.article.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserComparatorMain {
    public static void main(String[] args) {
        User u1=new User(1,"Ayush");
        User u3=new User(2,"Ram");
        User u2=new User(3,"Byush");
        List<User> users = Arrays.asList(u3, u1, u2);
        System.out.println(users);

        Collections.sort(users,new User());
        System.out.println(users);
    }
}
