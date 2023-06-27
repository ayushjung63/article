package com.ayush.article.pass;

public class JavaPassByValueOrReferece {
    public static void main(String[] args) {
        Integer num = 5;
        String input = "Hello World";
        manipulate("Integer value:"+5);
        manipulate("String value: "+input);
        System.out.println(num);
        System.out.println(input);

        Developer javaDeveloper=new Developer("John Doe","Java");
        manipulate(javaDeveloper);
        System.out.println(javaDeveloper.getDepartment());

        Developer reactDeveloper=new Developer("Jane Doe","React");
    }

    public static void manipulate(Developer developer){
        developer.setDepartment("Java Modified");
    }

    public static void manipulate(Integer input) {
        input = 7;
    }

    public static void manipulate(String input) {
        input = "Hello World Manipulated";
    }
}
