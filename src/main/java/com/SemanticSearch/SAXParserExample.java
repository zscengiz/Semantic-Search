//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.SemanticSearch;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserExample {
    public SAXParserExample() {
    }
    public static void main(String[] args) {
        String filePath = "/Users/zcengiz/IdeaProjects/Semantic-Search/src/main/resources/trwiki-latest-pages-articles.xml";

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean isText = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("text")) {
                        this.isText = true;
                    }

                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (this.isText) {
                        String content = new String(ch, start, length);
                        String cleanedContent = SAXParserExample.cleanText(content);
                        System.out.println("Temizlenmiş Metin: ");
                        System.out.println(cleanedContent);
                        this.isText = false;
                    }

                }
            };
            saxParser.parse(new File(filePath), handler);
        } catch (Exception var5) {
            Exception e = var5;
            e.printStackTrace();
        }

    }

    public static String cleanText(String text) {
        text = text.replaceAll("<[^>]*>", "");
        text = text.replaceAll("\\{\\{[^\\}]*\\}\\}", "");
        text = text.replaceAll("\\[\\[[^\\]]*\\]\\]", "");
        text = text.replaceAll("&[^;]+;", "");
        text = text.replaceAll("\\s+", " ").trim();
        return text;
    }
}
