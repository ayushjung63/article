package com.ayush.article;

public class demo
{
public static void main(String[] args) 
{
    String str1, str2;

    str1="A \"Hello, World!\" program is generally a computer program that ignores any input, and outputs\n" +
            "or displays a message similar to \"Hello, World!\". A small piece of code in most general-purpose\n" +
            "programming languages, this program is used to illustrate a language's basic syntax. \"Hello,\n" +
            "World!\" programs are often the first a student learns to write in a given language,[1] and they\n" +
            "can also be used as a sanity check to ensure computer software intended to compile or run\n" +
            "source code is correctly installed, and that its operator understands how to use it.";


    str2= "In the above example, the main( ) function defines where the program should start executing.\n" +
            "The function body consists of a single statement, a call to the printf function, which stands for\n" +
            "\"print formatted\". This function will cause the program to output whatever is passed to it as the\n" +
            "parameter, in this case the string hello, world.";


    int re=pecentageOfTextMatch(str1, str2);
    System.out.println("Matching Percent: "+re);
}

public static int pecentageOfTextMatch(String s0, String s1) 
{                       // Trim and remove duplicate spaces
    int percentage = 0;
    s0 = s0.trim().replaceAll("\\s+", " ");
    s1 = s1.trim().replaceAll("\\s+", " ");
    percentage=(int) (100 - (float) LevenshteinDistance(s0, s1) * 100 / (float) (s0.length() + s1.length()));
    return percentage;
}

public static int LevenshteinDistance(String s0, String s1) {

    int len0 = s0.length() + 1;
    int len1 = s1.length() + 1;  
    // the array of distances
    int[] cost = new int[len0];
    int[] newcost = new int[len0];

    // initial cost of skipping prefix in String s0
    for (int i = 0; i < len0; i++)
        cost[i] = i;

    // dynamically computing the array of distances

    // transformation cost for each letter in s1
    for (int j = 1; j < len1; j++) {

        // initial cost of skipping prefix in String s1
        newcost[0] = j - 1;

        // transformation cost for each letter in s0
        for (int i = 1; i < len0; i++) {

            // matching current letters in both strings
            int match = (s0.charAt(i - 1) == s1.charAt(j - 1)) ? 0 : 1;

            // computing cost for each transformation
            int cost_replace = cost[i - 1] + match;
            int cost_insert = cost[i] + 1;
            int cost_delete = newcost[i - 1] + 1;

            // keep minimum cost
            newcost[i] = Math.min(Math.min(cost_insert, cost_delete),
                    cost_replace);
        }

        // swap cost/newcost arrays
        int[] swap = cost;
        cost = newcost;
        newcost = swap;
    }

    // the distance is the cost for transforming all letters in both strings
    return cost[len0 - 1];
}

}