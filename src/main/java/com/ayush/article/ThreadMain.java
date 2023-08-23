package com.ayush.article;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder sb=new StringBuilder("");
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<10;i++) {
                        int finalI = i;
                        sb.append(finalI);
                    }
                }
            });
            t1.start();
            while (t1.isAlive()) {
                System.out.println(sb.length());
                System.out.println(sb);
            }


        StringBuffer buffer=new StringBuffer("");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++) {
                    int finalI = i;
                    buffer.append(finalI);
                }
            }
        });
        t2.start();
        while (t2.isAlive()) {
            System.out.println(buffer.length());
            System.out.println(buffer);
        }
    }
}
