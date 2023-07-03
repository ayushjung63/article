//package com.ayush.article.opencv;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.*;
//
//public class Cossine {
//
//    public static void main(String[] args) throws IOException {
//        // Get the two documents
//        File document1 = new File("document1.txt");
//        File document2 = new File("document2.txt");
//
//        // Get the total number of lines in the two documents
//        int totalLines1 = 0;
//        int totalLines2 = 0;
//        try (Scanner scanner1 = new Scanner(document1)) {
//            while (scanner1.hasNextLine()) {
//                totalLines1++;
//                scanner1.nextLine();
//            }
//        }
//        try (Scanner scanner2 = new Scanner(document2)) {
//            while (scanner2.hasNextLine()) {
//                totalLines2++;
//                scanner2.nextLine();
//            }
//        }
//        int totalSentences = totalLines1 + totalLines2;
//
//        // Calculate the similarity percentage
//        double similarityPercentage = (double) similarSentences / totalSentences * 100;
//
//        // Print the similarity percentage
//        System.out.println("The similarity percentage is " + similarityPercentage + "%");
//    }
//
//    private static double calculateCosineSimilarity(Map<String, Integer> wordCounts1, Map<String, Integer> wordCounts2) {
//        // Calculate the magnitude of the first vector
//        double vector1Magnitude = 0;
//        for (Integer count : wordCounts1.values()) {
//            vector1Magnitude += count * count;
//        }
//        vector1Magnitude = Math.sqrt(vector1Magnitude);
//
//        // Calculate the magnitude of the second vector
//        double vector2Magnitude = 0;
//        for (Integer count : wordCounts2.values()) {
//            vector2Magnitude += count * count;
//        }
//        vector2Magnitude = Math.sqrt(vector2Magnitude);
//
//        // Calculate the dot product of the two vectors
//        double dotProduct = 0;
//        for (String word : wordCounts1.keySet()) {
//            if (wordCounts2.containsKey(word)) {
//                dotProduct += wordCounts1.get(word) * wordCounts2.get(word);
//            }
//        }
//
//        // Return the cosine similarity
//        return dotProduct / (vector1Magnitude * vector2Magnitude);
//    }
//}
