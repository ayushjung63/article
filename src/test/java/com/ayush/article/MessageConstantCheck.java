package com.ayush.article;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MessageConstantCheck {
    public static void main(String[] args) throws Exception {

        List<Thread> threadList = new ArrayList<Thread>();
        Path resourceDirectory = Paths.get("src", "test", "resources");
        File file = new File(resourceDirectory + "/MessageConstants");
        File messagesNP = new File(resourceDirectory + "/messages_np");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        BufferedReader messageNPReader = new BufferedReader(new FileReader(messagesNP));
        List<String> messageConstantList=new ArrayList<>();

        do{
            String string = bufferedReader.readLine();
            String[] split = string.split("=");
            if (split.length > 1) {
                String messageConstantKey = split[1];
                String commaRemoved = messageConstantKey.substring(0, messageConstantKey.length() - 1);
                int startIndex = commaRemoved.indexOf("\"") + 1; // Finds the first apostrophe and adds 1 to get the starting index
                int endIndex = commaRemoved.lastIndexOf("\""); // Finds the last apostrophe to get the ending index
                String result = commaRemoved.substring(startIndex, endIndex);
                messageConstantList.add(result.trim());
            }
        }while (bufferedReader.readLine() !=null);

        List<String> messageNPList=new ArrayList<>();

       while ( messageNPReader.readLine()!=null){
            String stringNP = messageNPReader.readLine();
            String[] split = stringNP.split("=");
            if (split.length > 1) {
                String messageConstantKey = split[0];
                messageNPList.add(messageConstantKey.trim());
                System.out.println(messageConstantKey);
            }
        }

        bufferedReader.close();
        messageNPReader.close();
        System.out.println("Message Constant Size:"+messageConstantList.size());
        System.out.println("Message NP Size:"+messageNPList.size());

        List<String> notFoundList=new ArrayList<>(messageNPList);

        notFoundList.removeAll(messageConstantList);
        for (String object : notFoundList) {
            System.out.println(object);
        }

        System.out.println(notFoundList.size());
    }

}
