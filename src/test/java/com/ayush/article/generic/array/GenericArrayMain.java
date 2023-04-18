package com.ayush.article.generic.array;

public class GenericArrayMain {
    public static void main(String[] args) {
        Integer[] numbers={1,2};
        String[] strings={"A","B"};
        swap(numbers);
        swap(strings);
        print(numbers);
        print(strings);
//        System.out.println(numbers[0]+" "+numbers[1]);
//        System.out.println(strings[0]+" "+strings[1]);
    }

    public static  <T> void swap(T[] array){
        T temp=array[1];
        array[1]=array[0];
        array[0]=temp;
    }


    public static  <T> void print(T[] array){
       for (T t : array){
           System.out.println(t);
       }
    }
}
