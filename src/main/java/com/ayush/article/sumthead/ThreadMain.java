package com.ayush.article.sumthead;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        AtomicReference<Integer> firstResult= new AtomicReference<>(0);
        AtomicReference<Integer> secondResult= new AtomicReference<>(0);

        List<Integer> firstNumberList= Arrays.asList(1,2,3,4,5);
        List<Integer> secondNumberList= Arrays.asList(6,7,8,9);
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                firstNumberList.stream().forEach(x->{
                    System.out.println("Inside First Thread");
                    firstResult.updateAndGet(v -> v + x);
                });
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                secondNumberList.stream().forEach(x->{
                    if (x==9){
                        throw new RuntimeException("Hello");
                    }
                    secondResult.updateAndGet(v -> v + x);
                });
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Integer finalResult=firstResult.get()+secondResult.get();
        System.out.println(finalResult);


    }
}
