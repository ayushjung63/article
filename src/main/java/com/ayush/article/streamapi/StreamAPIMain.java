package com.ayush.article.streamapi;

import java.util.*;
import java.util.stream.Collectors;

class StreamAPIMain{
    public static void main(String[] args){
        List<Integer> numberList=Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> oddNumberList=numberList.stream().filter(x-> x%2!=0).collect(Collectors.toList());
        System.out.println(oddNumberList);

        long sum = numberList.stream()
                .collect(Collectors.summarizingInt(Integer::intValue)).getSum();
        System.out.println(sum);
    }
}
