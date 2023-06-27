package com.ayush.article;

public class StringSwap {
    public static void main(String[] args) {
        String firstString="Ayush";
        String secondString="Basnet";

        firstString=firstString+secondString; // Hi Hello
        secondString=firstString.substring(0,(firstString.length()-secondString.length()));
        firstString=firstString.substring(secondString.length());
        System.out.println(firstString);
        System.out.println(secondString);
    }
}
