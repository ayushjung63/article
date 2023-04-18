package com.ayush.article;

public class RemoveOccuranceString {
    public static void main(String[] args) {
        String hello="HeeeeeeeeH";
        StringBuilder builder=new StringBuilder();
        char toRemoveChar='e';
        char[] chars = hello.toCharArray();
        for (char c: chars){
            if (c != toRemoveChar){
                builder.append(c);
            }
        }
        System.out.println(builder);

    }
}
