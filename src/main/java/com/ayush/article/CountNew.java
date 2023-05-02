package com.ayush.article;

import java.util.Stack;

public class CountNew {
    public static void main(String[] args) {
        String str = "wwwwaaadexxxxxxwww";
        Stack stringStack=new Stack();
        String[] split = str.split("");
        int count = 1;
        for (int i=0;i<split.length;i++){
            String s = split[i];
            if (stringStack.isEmpty()){
                stringStack.push(s);
            }else {
                String peek = (String) stringStack.peek();
                if (peek.equals(s)) {
                    count++;
                    if (i == split.length-1){
                        System.out.print(peek + count);
                    }
                } else {
                    System.out.print(peek + count);
                    stringStack.pop();
                    count=1;
                    stringStack.push(s);
                }
            }
        }
    }
}
