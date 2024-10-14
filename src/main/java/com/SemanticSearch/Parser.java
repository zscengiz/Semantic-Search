package com.SemanticSearch;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static void parseXmlAndStoreInMongo(String filePath) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new File(filePath));
            Element rootElement = document.getRootElement();
            List<org.bson.Document> documents = new ArrayList<>();

            for (Element page : rootElement.getChildren("page")) {
                String title = page.getChildText("title");
                String content = page.getChild("revision").getChildText("text");

                System.out.println("Processing title: " + title);

                String cleanedContent = Utils.cleanText(content);
                List<String> words = Utils.splitText(cleanedContent);
                List<String> synonyms = Utils.getSynonyms(words);

                String url = "https://tr.wikipedia.org/wiki/" + title;

                org.bson.Document mongoDocument = new org.bson.Document()
                        .append("title", title)
                        .append("content", cleanedContent)
                        .append("words", words)
                        .append("synonyms", synonyms)
                        .append("url", url);

                documents.add(mongoDocument);
            }

            for (org.bson.Document doc : documents) {
                Database.insertDocument(doc);
            }

        } catch (Exception e) {
            System.out.println("Error: Failed to parse XML file - " + e.getMessage());
        }
    }
}
