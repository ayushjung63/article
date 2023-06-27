package com.ayush.article.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PredicateSupplierConsumerMain {
    public static void main(String[] args) {
        List<Integer> numberList= Arrays.asList(1,2,3,4,5);
        Predicate<Integer> isEven=num->num%2==0;
        List<Integer> evenNumberList = numberList.stream()
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println(evenNumberList);


        Supplier<Integer> otpGenerator=()->{
            Random random=new Random();
            return random.nextInt(9999);
        };
        System.out.println(otpGenerator.get());
        System.out.println(otpGenerator.get());

        Consumer<Integer> printer= data -> System.out.println(data);
        numberList.stream().forEach(printer);
    }
}
