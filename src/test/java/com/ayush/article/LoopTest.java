package com.ayush.article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LoopTest {
    public static void main(String[] args) {
        StringTest A = new StringTest("A", 1);
        StringTest B = new StringTest("B", 2);
        StringTest C = new StringTest("C", 3);
        StringTest D = new StringTest("D", 4);

        List<StringTest> allData = Arrays.asList(A, B, C, D);
        List<StringTest> toCheck = Arrays.asList(A, B);

        HashSet<StringTest> foundList = new HashSet<>();
        HashSet<StringTest> notFoundList = new HashSet<>();

        allData.stream().forEach(x->{
            toCheck.forEach(y->{
                if (x.getEmpName().equals(y.getEmpName())){
                    if (notFoundList.contains(x)){
                        notFoundList.remove(x);
                    }
                    foundList.add(x);
                }else{
                    if (! foundList.contains(x)) {
                        notFoundList.add(x);
                    }
                }
            });
        });

        foundList.parallelStream().forEach(x->{
            System.out.println("Found : "+x.getEmpName());
        });

        notFoundList.parallelStream().forEach(x->{
            System.out.println("Not Found : "+x.getEmpName());
        });
    }
}
