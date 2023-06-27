package com.ayush.article.methodhiding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Parent {
    public static void hello(){
        System.out.println("Parent");
    }
}
