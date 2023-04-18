package com.ayush.article;

public class PalindromeString {
    public static void main(String[] args) {
        String hello="hello";
//        checkPalindrome(hello);
        checkPalindrome("DAD");
    }

    private static void checkPalindrome(String hello) {
        var helloBuilder=new StringBuilder(hello);
        var reverse = helloBuilder.reverse();
        if (hello.equals(reverse)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }
}
