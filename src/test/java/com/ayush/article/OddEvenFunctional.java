package com.ayush.article;

import java.util.function.Consumer;
import java.util.function.Function;

public class OddEvenFunctional {
    public static void main(String[] args) {
        Function<Integer,String> check=(x)-> x%2 == 0 ? "EVEN" : "ODD";
        System.out.println(check.apply(1));
    }
}
