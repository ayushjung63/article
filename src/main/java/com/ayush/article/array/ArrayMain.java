package com.ayush.article.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMain {
    public static void main(String[] args) {
        List<String> stringList= new ArrayList<String>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("B");

        System.out.println("List Size:"+stringList.size());
        System.out.println("Before Removing:"+stringList.get(1));
        stringList.remove("B");

        System.out.println("After Removing:"+stringList.get(1));
        System.out.println("List Size:"+stringList.size());

        List<Integer> numerList= new ArrayList<Integer>();
        numerList.add(0);
        numerList.add(1);
        numerList.add(5);
        numerList.add(3);

        System.out.println("List Size:"+numerList.size());
        System.out.println("Before Removing:"+numerList.get(2));
//        numerList.remove(2);
        numerList.remove(Integer.valueOf(5));
        System.out.println("After Removing:"+numerList.get(2));
        System.out.println("List Size:"+numerList.size());
    }
}
