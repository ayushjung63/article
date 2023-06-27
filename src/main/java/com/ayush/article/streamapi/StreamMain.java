package com.ayush.article.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3");
        List<Integer> numbers = strings.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
        System.out.println(numbers);

        List<Integer> numberList=Arrays.asList(1,2,3,4,5);
        List<Integer> oddNumberList = numberList.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
        System.out.println(oddNumberList);
    }
}
