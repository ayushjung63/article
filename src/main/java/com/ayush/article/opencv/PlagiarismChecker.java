package com.ayush.article.opencv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PlagiarismChecker {
    public static void main(String[] args) throws IOException {
        String filePath1 = "/home/shady/Desktop/Jasper/3.pdf";
        String filePath2 = "/home/shady/Desktop/Jasper/4.pdf";

        String sourceText = readTextFromFile(filePath1);
        String targetText = readTextFromFile(filePath2);

        double similarityScore = calculateJaccardSimilarity(sourceText, targetText);

        double similarityThreshold = 0.8;
        System.out.println(similarityScore);
        if (similarityScore >= similarityThreshold) {
            System.out.println("Plagiarism detected!");
        } else {
            System.out.println("No plagiarism detected.");
        }
    }

    public static String readTextFromFile(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public static double calculateJaccardSimilarity(String sourceText, String targetText) {
        Set<String> sourceTokens = tokenizeText(sourceText);
        Set<String> targetTokens = tokenizeText(targetText);

        Set<String> intersection = new HashSet<>(sourceTokens);
        intersection.retainAll(targetTokens);

        Set<String> union = new HashSet<>(sourceTokens);
        union.addAll(targetTokens);

        double similarity = (double) intersection.size() / union.size();
        return similarity;
    }

    public static Set<String> tokenizeText(String text) {
        String[] tokens = text.toLowerCase().split("\\s+");

        Set<String> uniqueTokens = new HashSet<>();
        for (String token : tokens) {
            // Add additional preprocessing if needed
            uniqueTokens.add(token);
        }

        return uniqueTokens;
    }
}
