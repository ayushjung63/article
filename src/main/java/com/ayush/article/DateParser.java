package com.ayush.article;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateParser {
    public static LocalDate parseDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format!");
            return null;
        }
    }

    public static void main(String[] args) {
        String[] dateStrings = {"2023-7-4", "2023-7-14", "2023-10-2", "2023-10-11"};
        for (String dateString : dateStrings) {
            LocalDate date = parseDate(dateString);
            if (date != null) {
                System.out.println(date);
            }
        }
    }
}
