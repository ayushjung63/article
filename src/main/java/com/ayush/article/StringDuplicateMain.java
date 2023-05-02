package com.ayush.article;

import java.util.*;

public class StringDuplicateMain {
    public static void main(String[] args) {
        String str = "Fear leads to anger; anger leads to hatred; hatred leads to conflict; conflict leads to suffering.";
        HashMap<String,Integer> hashMap=new HashMap<>();
        String[] split = str.split("");
        for (String s : split){
            if (s.equals(" ")) continue;
            boolean containsKey = hashMap.containsKey(s);
            if (containsKey){
                Integer count = hashMap.get(s);
                hashMap.put(s,count+1);
            }else{
                hashMap.put(s,1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        entries.stream().forEach(x->{
            System.out.print(x.getKey()+ x.getValue());
        });

    }
}
