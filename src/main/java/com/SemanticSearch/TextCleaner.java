//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.SemanticSearch;

public class TextCleaner {
    public TextCleaner() {
    }

    public static String cleanContent(String content) {
        return content.replaceAll("\\<.*?\\>", "").trim();
    }
}
