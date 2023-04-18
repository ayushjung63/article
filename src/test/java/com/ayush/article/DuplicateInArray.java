package com.ayush.article;

import java.util.HashSet;
import java.util.Set;

public class DuplicateInArray {
    public static void main(String[] args) {
        int[] numbers={1,2,1,3,4,5,5};
        HashSet<Integer> numbersSet=new HashSet<>();
        for (int n : numbers){
            numbersSet.add(n);
        }
        System.out.println(numbersSet);
    }

}
