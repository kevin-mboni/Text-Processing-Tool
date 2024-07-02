package com.example.textprocessing_data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessingModule {
    public String searchPattern(String patternStr, String text) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append("Found match: ").append(matcher.group()).append(" at position ").append(matcher.start()).append("\n");
        }
        if(result.isEmpty()) {result.append("Not found");}
        return result.toString();
    }

    public String replacePattern(String patternStr, String replacement, String text) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(replacement);
    }
}
