package com.ayush.article.opencv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DocumentSimilarity2 {
    public static void main(String[] args) {
        String filePath1 = "/home/shady/Desktop/Jasper/5.pdf";
        String filePath2 = "/home/shady/Desktop/Jasper/6.pdf";
        try {
            String text1 = readTextFromFile(filePath1);
            String text2 = readTextFromFile(filePath2);

            double similarity = calculateCosineSimilarity(text2, text1);

            System.out.println("Cosine Similarity: " + similarity);
        } catch (Exception e) {
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

    public static double calculateCosineSimilarity(String text1, String text2) {
        Set<String> words1 = new HashSet<>(Arrays.asList(text1.split("\\s+")));
        Set<String> words2 = new HashSet<>(Arrays.asList(text2.split("\\s+")));

        // Calculate the intersection of words
        Set<String> intersection = new HashSet<>(words1);
        intersection.retainAll(words2);

        // Calculate the cosine similarity
        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;

        for (String word : intersection) {
            dotProduct += countOccurrences(text1, word) * countOccurrences(text2, word);
        }

        for (String word : words1) {
            magnitude1 += Math.pow(countOccurrences(text1, word), 2);
        }

        for (String word : words2) {
            magnitude2 += Math.pow(countOccurrences(text2, word), 2);
        }

        double similarity = dotProduct / (Math.sqrt(magnitude1) * Math.sqrt(magnitude2));
        return similarity;
    }

    public static int countOccurrences(String text, String word) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}
