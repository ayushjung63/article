package com.ayush.article.opencv;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class PlagiarismChecker {
    public static void main(String[] args) throws IOException, TikaException, SAXException {
        String filePath1 = "/home/shady/Desktop/Jasper/BloodBankFinalProposal.pdf";
        String filePath2 = "/home/shady/Desktop/Jasper/BloodBankFinalProposal.pdf";

        String sourceText = readContentFromPdf(filePath1);
        String targetText = readContentFromPdf(filePath2);

        double similarityScore = calculateJaccardSimilarity(sourceText, targetText);

        double similarityThreshold = 0.8;
        System.out.println(similarityScore);
        if (similarityScore >= similarityThreshold) {
            System.out.println("Plagiarism detected!");
        } else {
            System.out.println("No plagiarism detected.");
        }
    }

    public static String readContentFromPdf(String path) throws IOException, TikaException, SAXException {
        // Create a content handler
        BodyContentHandler contenthandler
                = new BodyContentHandler();

        // Create a file in local directory
        File f = new File(path);

        // Create a file input stream
        // on specified path with the created file
        FileInputStream fstream = new FileInputStream(f);

        // Create an object of type Metadata to use
        Metadata data = new Metadata();

        // Create a context parser for the pdf document
        ParseContext context = new ParseContext();

        // PDF document can be parsed using the PDFparser
        // class
        PDFParser pdfparser = new PDFParser();

        // Method parse invoked on PDFParser class
        pdfparser.parse(fstream, contenthandler, data,
                context);

        return  contenthandler.toString();
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
