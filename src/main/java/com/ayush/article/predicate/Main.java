package com.ayush.article.predicate;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Main main=new Main();
        System.out.println(main.isJavaDev.test(new Developer("Java")));

        int i=1;
        i++;
        i++;
        i++;
        ++i;
        System.out.println(++i);

    }
    Predicate<Developer> isJavaDev=(dev)-> dev.getDept().equals("Java");
}
