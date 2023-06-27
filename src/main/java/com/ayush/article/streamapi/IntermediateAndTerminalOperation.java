package com.ayush.article.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateAndTerminalOperation {
    public static void main(String[] args) {
        List<Integer> numberList1 = Arrays.asList(1, 2, 3,4,5);
        List<Integer> newList = numberList1.stream()
                .map(x -> x * x) //returns new stream //intermediate
                .filter(y -> y % 2 == 0) //returns new stream intermediate
                .collect(Collectors.toList()); //terminal
        System.out.println(newList);
        newList.forEach(x-> System.out.println(x)); //terminal


        List<Integer> peekedAndMappedList = numberList1.stream().peek(x -> System.out.println(x)) //view element on flow
                .filter(x -> x % 2 != 0).collect(Collectors.toList());
        System.out.println(peekedAndMappedList);

        List<String> nameList=Arrays.asList("Ayush","Basnet");
        List<String> ayush = nameList.stream()
                .peek(x -> x = x.toUpperCase())
                .filter(x -> x.equals("AYUSH"))
                .collect(Collectors.toList());
        System.out.println(ayush);
    }
}
