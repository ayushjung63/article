package com.ayush.article.staticdemo;

class ParentClass {
    private int num;
    static class NestedStaticClass{
        public void hello(){
            System.out.println("Hello from Nested Static Class.");
        }
    }

    class NestedNormalClass{
        public void hello(){
            System.out.println("Hello from Nested  Normal Static Class.");
        }
    }
}
