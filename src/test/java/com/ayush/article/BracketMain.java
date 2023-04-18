package com.ayush.article;

import java.util.Stack;

public class BracketMain {
    public static void main(String[] args) {
        String toCheck="({})";
        Stack<String> stringStack=new Stack<>();
        String[] split = toCheck.split("");
        for (String s : split){
            stringStack.push(s);
        }
        
    }
}
