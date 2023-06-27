package com.ayush.article.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapMain {
    public static void main(String[] args) {
        List<Integer> numberList1 = Arrays.asList(1, 2, 3);
        List<Integer> numberList2 = Arrays.asList(4, 5, 6);
        List<Integer> numberList3 = Arrays.asList(7, 8, 9);
        List<List<Integer>> lists = Arrays.asList(numberList1, numberList2, numberList3);
        System.out.println(lists);

        //flatmap
        List<Integer> newList = lists.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(newList);
    }
}
