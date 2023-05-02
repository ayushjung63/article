package com.ayush.article;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SumArray {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, -3, 4, 5, 6, -7, 8, 9, 10);
        Optional<Integer> data = ls.stream().reduce((x, y) -> x + y).map(y -> {
            if (y % 2 == 0) return y * 2;
            else if (y < 0) throw new RuntimeException("Negative Number");
            else return y;
        });
        System.out.println(data.get());

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> filteredData = list.stream().filter(x -> x % 2 != 0).map(x -> x * 2).collect(Collectors.toList());
        System.out.println(filteredData);
    }
}
