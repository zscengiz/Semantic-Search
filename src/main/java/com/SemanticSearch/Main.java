package com.SemanticSearch;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure()
                .directory("src/main/resources")
                .load();


        String databaseUrl = dotenv.get("DATABASE_URL");
        String databasePassword = dotenv.get("DATABASE_PASSWORD");

        System.out.println("DATABASE_URL: " + databaseUrl);
        System.out.println("DATABASE_PASSWORD: " + databasePassword);



        if (databaseUrl == null || databasePassword == null) {
            System.err.println("Environment variables not found!");
            return;
        }


        Database.connect();

        File folder = new File("src/main/resources");
        for (File file : folder.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".xml")) {
                Parser.parseXmlAndStoreInMongo(file.getAbsolutePath());
                System.out.println("Successfully processed: " + file.getName());
            }
        }
    }
}
