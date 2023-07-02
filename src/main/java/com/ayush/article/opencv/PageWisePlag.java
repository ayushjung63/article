package com.ayush.article.opencv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PageWisePlag {
    public static void main(String[] args) {
        String sourceFilePath = "/home/shady/Desktop/Jasper/4.pdf";
        String targetFilePath = "/home/shady/Desktop/Jasper/3.pdf";
        double similarityThreshold = 0.8;

        try {
            String sourceText = readTextFromFile(sourceFilePath);
            String targetText = readTextFromFile(targetFilePath);

            String[] sourcePages = splitIntoPages(sourceText);
            String[] targetPages = splitIntoPages(targetText);

            for (int i = 0; i < sourcePages.length; i++) {
                double similarityScore = calculateJaccardSimilarity(sourcePages[i], targetPages[i]);

                if (similarityScore >= similarityThreshold) {
                    System.out.println("Plagiarism detected in page " + (i + 1) + "!");
                } else {
                    System.out.println("No plagiarism detected in page " + (i + 1) + ".");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    public static String[] splitIntoPages(String text) {
        // Split the text into pages based on your document's structure
        // This can be done using specific delimiters or page markers

        // Example: Splitting by page number
        String[] pages = text.split("Page\\d+:");

        return pages;
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
