package com.ayush.article.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList arrayList=new ArrayList();
        arrayList.add(1);
        arrayList.add("Ayush");

//        for (Object o : arrayList){
//            String o2=(String) o ;
//            System.out.println(o2);
//        }

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
