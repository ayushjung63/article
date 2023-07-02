package com.ayush.article.opencv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TextSimilarityAnalyzer {
    public static void main(String[] args) {
        String filePath1 = "/home/shady/Desktop/Jasper/3.pdf";
        String filePath2 = "/home/shady/Desktop/Jasper/4.pdf";

        try {
            String document1 = readDocumentFromFile(filePath1);
            String document2 = readDocumentFromFile(filePath2);
//
//            String document11 = "It is developed using Java";
//            String document22 = "It is developed using PHP";
            double similarity = calculateTextSimilarity(document1, document2);
//            double similarity = calculateTextSimilarity(document11, document22);
            double similarityPercentage = similarity * 100;
            System.out.println("Text Similarity: " + similarityPercentage + "%");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String readDocumentFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        }
       return content.toString();
    }

    public static double calculateTextSimilarity(String text1, String text2) {
        // Tokenize the text by splitting on whitespace
        String[] tokens1 = text1.toLowerCase().split("\\s+");
        String[] tokens2 = text2.toLowerCase().split("\\s+");

        // Create a set to store unique tokens from both documents
        Set<String> uniqueTokens = new HashSet<>(Arrays.asList(tokens1));
        uniqueTokens.addAll(Arrays.asList(tokens2));

        // Create the term frequency vectors
        int[] vector1 = new int[uniqueTokens.size()];
        int[] vector2 = new int[uniqueTokens.size()];

        // Calculate term frequency for text 1
        for (String token : tokens1) {
            int index = 0;
            for (String uniqueToken : uniqueTokens) {
                if (token.equals(uniqueToken)) {
                    vector1[index]++;
                    break;
                }
                index++;
            }
        }

        // Calculate term frequency for text 2
        for (String token : tokens2) {
            int index = 0;
            for (String uniqueToken : uniqueTokens) {
                if (token.equals(uniqueToken)) {
                    vector2[index]++;
                    break;
                }
                index++;
            }
        }

        // Calculate the dot product of the vectors
        double dotProduct = 0;
        for (int i = 0; i < uniqueTokens.size(); i++) {
            dotProduct += vector1[i] * vector2[i];
        }

        // Calculate the magnitude of the vectors
        double magnitude1 = calculateVectorMagnitude(vector1);
        double magnitude2 = calculateVectorMagnitude(vector2);

        // Calculate the cosine similarity
        double similarity = dotProduct / (magnitude1 * magnitude2);
        return similarity;
    }

    private static double calculateVectorMagnitude(int[] vector) {
        int sumOfSquares = 0;
        for (int value : vector) {
            sumOfSquares += value * value;
        }
        return Math.sqrt(sumOfSquares);
    }
}
