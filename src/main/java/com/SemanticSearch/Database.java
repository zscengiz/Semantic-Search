package com.SemanticSearch;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Database {
    private static MongoCollection<Document> collection;

    public static void connect() {
        try {

            String databaseUrl = System.getenv("DATABASE_URL");
            if (databaseUrl == null) {
                throw new IllegalArgumentException("DATABASE_URL is not set.");
            }

            MongoClient client = MongoClients.create(databaseUrl);
            MongoDatabase database = client.getDatabase("wikipedia");
            collection = database.getCollection("wikipedia_tr");
            System.out.println("Connected to MongoDB.");
        } catch (Exception e) {
            System.out.println("Error: Could not connect to MongoDB! " + e.getMessage());
        }
    }

    public static void insertDocument(Document document) {
        try {
            Document existingDocument = collection.find(new Document("title", document.getString("title"))).first();
            if (existingDocument != null) {
                System.out.println("Document with title '" + document.getString("title") + "' already exists, skipping.");
                return;
            }
            collection.insertOne(document);
            System.out.println("Document successfully added: " + document.getString("title"));
        } catch (Exception e) {
            System.out.println("Error: Could not insert document! " + e.getMessage());
        }
    }
}
