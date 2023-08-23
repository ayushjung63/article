package com.ayush.article.accessmodifier.p2;

import com.ayush.article.accessmodifier.p1.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Audi extends Car {
    public static void main(String[] args) {
        Audi audi=new Audi();
        audi.msg();
    }
}
