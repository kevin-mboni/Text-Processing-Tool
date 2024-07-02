package com.example.textprocessing_data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexModule {

    public static void searchPattern(String patternStr, String text) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            if (matcher.groupCount() != 0) {System.out.println("Found match: " + matcher.group() + " at position " + matcher.start());}
            else {System.out.println("No match: " + matcher.group() + " at position " + matcher.start());}
        }
    }

    // Method to replace a pattern in text
    public static String replacePattern(String patternStr, String replacement, String text) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(replacement);
    }

    public static void main(String[] args) {
        // Sample text and pattern
        String text = "The quick brown fox jumps over the lazy dog.";
        String pattern = "\\b[a-z]{4}\\b"; // Words with exactly 4 letters

        // Search for pattern
        searchPattern(pattern, text);

        // Replace pattern
        String replacedText = replacePattern(pattern, "****", text);
        System.out.println("Replaced text: " + replacedText);
    }
}
