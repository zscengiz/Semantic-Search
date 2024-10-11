//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.SemanticSearch;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {
    public XMLReader() {
    }

    public static void main(String[] args) {
        String filePath = "/Users/zcengiz/Semantic--Search/src/main/resources/text-wiki.xml";
        List<String> cleanedTexts = readXMLFile(filePath);
        Iterator var3 = cleanedTexts.iterator();

        while(var3.hasNext()) {
            String text = (String)var3.next();
            System.out.println("Temizlenmiş Metin: ");
            System.out.println(text);
        }

    }

    public static List<String> readXMLFile(String filePath) {
        List<String> texts = new ArrayList();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("page");

            for(int i = 0; i < nList.getLength(); ++i) {
                Node node = nList.item(i);
                if (node.getNodeType() == 1) {
                    Element element = (Element)node;
                    String textContent = element.getElementsByTagName("text").item(0).getTextContent();
                    String cleanedText = cleanText(textContent);
                    texts.add(cleanedText);
                }
            }
        } catch (Exception var12) {
            Exception e = var12;
            e.printStackTrace();
        }

        return texts;
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
