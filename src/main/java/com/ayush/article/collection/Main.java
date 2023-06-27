package com.ayush.article.collection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        linkedList.add(2);
        System.out.println(linkedList.get(0));

        HashMap<String,Integer> hashMap=new HashMap();
        hashMap.put("a",2);

        System.out.println(hashMap.get("a"));
        for (Map.Entry entry : hashMap.entrySet()){
                if (entry.getValue().equals(2)){
                    System.out.println(entry.getKey());
                }
        }

    }
}
