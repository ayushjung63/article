package com.ayush.article.accessmodifier.p1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Car {
    protected void msg(){
        System.out.println("Protected Car");
    }
}
