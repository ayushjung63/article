package com.ayush.article.opencv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DocumentSimilarity {
    public static void main(String[] args) {
        String filePath1 = "/home/shady/Desktop/Jasper/BloodBankFinalProposal.pdf";
        String filePath2 = "/home/shady/Desktop/Jasper/BloodBankFinalProposal.pdf";

        try {
            double similarityPercentage = calculateDocumentSimilarity(filePath1, filePath2);
            System.out.println("Document Similarity: " + similarityPercentage + "%");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double calculateDocumentSimilarity(String filePath1, String filePath2) throws IOException {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
             BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            int totalChars1 = 0;
            int totalChars2 = 0;
            int commonChars = 0;

            while (line1 != null && line2 != null) {
                totalChars1 += line1.length();
                totalChars2 += line2.length();
                commonChars += calculateCommonCharacters(line1, line2);

                line1 = reader1.readLine();
                line2 = reader2.readLine();
            }

            double similarityPercentage = (double) commonChars / Math.max(totalChars1, totalChars2) * 100;
            return similarityPercentage;
        }
    }

    public static int calculateCommonCharacters(String str1, String str2) {
        int commonChars = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] distanceMatrix = new int[2][len2 + 1];

        for (int j = 0; j <= len2; j++) {
            distanceMatrix[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            char c1 = str1.charAt(i - 1);
            distanceMatrix[1][0] = i;
            for (int j = 1; j <= len2; j++) {
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    distanceMatrix[1][j] = distanceMatrix[0][j - 1];
                } else {
                    int delete = distanceMatrix[0][j] + 1;
                    int insert = distanceMatrix[1][j - 1] + 1;
                    int replace = distanceMatrix[0][j - 1] + 1;
                    distanceMatrix[1][j] = Math.min(Math.min(delete, insert), replace);
                }
            }
            System.arraycopy(distanceMatrix[1], 0, distanceMatrix[0], 0, len2 + 1);
        }

        commonChars = len1 + len2 - distanceMatrix[1][len2];
        return commonChars;
    }
}
