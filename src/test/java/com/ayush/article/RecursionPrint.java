package com.ayush.article;

public class RecursionPrint {
    public static void main(String[] args) {
        RecursionPrint print=new RecursionPrint();
        print.printInRecursion(1);


        int num=1;
        num++;
        System.out.println(num); //2
        System.out.println(num++); //2
    }
    public int printInRecursion(int num){
        if (num==0){
           return num;
        }
        else if (num>10){
            System.out.println("Completed");
            return 0;
        }else{
            System.out.println(num);
            num++;
            return printInRecursion(num);
        }
    }
}
