//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.SemanticSearch;

import java.util.HashSet;
import java.util.Set;

public class JaccardSimilarity {
    public JaccardSimilarity() {
    }

    public static void main(String[] args) {
        String text1 = "bu bir test cümlesidir";
        String text2 = "bu bir test cümlesidir";
        double similarity = jaccardSimilarity(text1, text2);
        System.out.println("Jaccard Benzerlik Skoru: " + similarity);
    }

    public static double jaccardSimilarity(String text1, String text2) {
        Set<String> words1 = new HashSet();
        Set<String> words2 = new HashSet();
        String[] var4 = text1.split(" ");
        int var5 = var4.length;

        int var6;
        String word;
        for(var6 = 0; var6 < var5; ++var6) {
            word = var4[var6];
            words1.add(word);
        }

        var4 = text2.split(" ");
        var5 = var4.length;

        for(var6 = 0; var6 < var5; ++var6) {
            word = var4[var6];
            words2.add(word);
        }

        Set<String> intersection = new HashSet(words1);
        intersection.retainAll(words2);
        Set<String> union = new HashSet(words1);
        union.addAll(words2);
        return (double)intersection.size() / (double)union.size();
    }
}
