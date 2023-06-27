package com.ayush.article.staticdemo;

public class ParentMain {
    public static void main(String[] args) {
        ParentClass.NestedStaticClass nestedStaticClass=new ParentClass.NestedStaticClass();
        nestedStaticClass.hello();

        ParentClass  parentClass=new ParentClass();
        ParentClass.NestedNormalClass nestedNormalClass= parentClass.new NestedNormalClass();
    }
}
