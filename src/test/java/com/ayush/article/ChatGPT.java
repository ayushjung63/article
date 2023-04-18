package com.ayush.article;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChatGPT {

    public static void main(String[] args) throws Exception {

        // Define the path to the resources directory
        Path resourceDirectory = Paths.get("src", "test", "resources");

        // Define the path to the MessageConstants file
        String messageConstantsFilePath = resourceDirectory.resolve("MessageConstants").toString();

        // Define the path to the messages_np file
        String messagesNPFilePath = resourceDirectory.resolve("messages_np").toString();

        // Create a set to store the message constants
        Set<String> messageConstantsSet = new HashSet<>();

        // Read from the MessageConstants file and extract the message constants
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(messageConstantsFilePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("=");
                if (split.length > 1) {
                    String messageConstantKey = split[1];
                    String commaRemoved = messageConstantKey.substring(0, messageConstantKey.length() - 1);
                    int startIndex = commaRemoved.indexOf("\"") + 1;
                    int endIndex = commaRemoved.lastIndexOf("\"");
                    String result = commaRemoved.substring(startIndex, endIndex);
                    messageConstantsSet.add(result.trim());
                }
            }
        }

        // Create a list to store the message NPs
        List<String> messageNPList = new ArrayList<>();

        // Read from the messages_np file and extract the message NPs
        try (BufferedReader messageNPReader = new BufferedReader(new FileReader(messagesNPFilePath))) {
            String line;
            while ((line = messageNPReader.readLine()) != null) {
                String[] split = line.split("=");
                if (split.length > 1) {
                    String messageConstantKey = split[0];
                    messageNPList.add(messageConstantKey.trim());
                }
            }
        }

        // Find the missing message constants that are not present in messageNPList
        List<String> notFoundList = new ArrayList<>();
        for (String messageConstant : messageConstantsSet) {
            if (!messageNPList.contains(messageConstant)) {
                notFoundList.add(messageConstant);
            }
        }

        // Print the missing message constants
        System.out.println("Message Constant Size: " + messageConstantsSet.size());
        System.out.println("Message NP Size: " + messageNPList.size());
        System.out.println("Number of missing messages: " + notFoundList.size());
        for (String message : notFoundList) {
            System.out.println(message);
        }
    }
}
