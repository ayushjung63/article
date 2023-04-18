package com.ayush.article.typecast;

public class BoxAndUnBox {
    public static void main(String[] args) {
        int i=2;
        Integer boxI= (Integer) i;
        System.out.println(boxI);

        Integer j=3;
        int unboxJ= (int) 3;
        System.out.println(unboxJ);
    }
}
