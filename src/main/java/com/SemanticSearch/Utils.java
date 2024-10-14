package com.SemanticSearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static String cleanText(String text) {
        return text.replaceAll("<ref>.*?</ref>", "")
                .replaceAll("\\[\\[.*?\\]\\]", "")
                .replaceAll("[{}]", "")
                .replaceAll("&lt;", "<")
                .replaceAll("&gt;", ">")
                .replaceAll("[^\\w\\s]", "")
                .trim();
    }

    public static List<String> splitText(String text) {
        return Arrays.asList(text.split("\\s+"));
    }

    public static List<String> getSynonyms(List<String> words) {

        return words.stream().map(word -> "Synonym_of_" + word).collect(Collectors.toList());
    }
}
