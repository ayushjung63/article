package com.ayush.article.note;

import java.util.*;

class Scratch {
    public static void main(String[] args) {
        Integer[] notes = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
        List<Integer> retunNotes = new ArrayList<>();
        Integer amt = 2745;
        Integer purchase = 1112;
        Integer returnAmt = amt - purchase;
        for (Integer note : notes) {
            if (returnAmt >= note) {
                Integer value = returnAmt / note;
                retunNotes.addAll(new ArrayList<Integer>(Collections.nCopies(value, note)));
                returnAmt -= (note * value);
            }
        }
        System.out.println(retunNotes);
    }
}