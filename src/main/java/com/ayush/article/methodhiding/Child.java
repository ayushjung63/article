package com.ayush.article.methodhiding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Child extends Parent {
    public static void hello(){
        System.out.println("Child");
    }
}
