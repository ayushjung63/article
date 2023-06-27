package com.ayush.article.note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoteMain {
    public static void main(String[] args) {
        Integer[] notes = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
        Integer amtToReturn=226;
        List<Integer> returnList=new ArrayList<>();
        Integer amtToCheck=amtToReturn;
        for (Integer note:notes){
            if (amtToCheck>=note){
                int division = amtToCheck / note;
                returnList.addAll(Collections.nCopies(division,note));
                int remainder = amtToCheck % note;
                amtToCheck=remainder;
            }
        }
        System.out.println(returnList.toString());
    }
}
