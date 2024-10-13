# Semantic Search Engine with Wikipedia TR Dataset *(Test Project)*

> **Disclaimer:** This project is for testing purposes only and is not intended for production use.

This project involves building a semantic search engine that retrieves synonyms of user-inputted words based on a corpus derived from Turkish Wikipedia articles. The system uses **Elasticsearch** for indexing and searching, and natural language processing techniques to generate a custom language model trained on Wikipedia data. The project aims to implement a prototype where users can input a word, and the system will return its synonyms.

## Table of Contents
- [Overview](#overview)
- [Requirements](#requirements)
- [Installation](#installation)
- [Dataset](#dataset)

## Overview
This project is developed by a team of three and is divided into the following major parts:
1. **Data Extraction:** Extract data from the Turkish Wikipedia dataset using `WikiExtractor`.
2. **Natural Language Processing (NLP):** Process the text data and build a custom synonym retrieval model using NLP techniques.
3. **Elasticsearch Integration:** Set up an Elasticsearch instance to index and search for synonyms of words entered by the user.
4. **Frontend Development:** Develop a simple web interface where users can input words, and the system returns relevant synonyms.

## Dataset
The dataset consists of Turkish Wikipedia articles. After extraction, the data is stored in JSON format. Each file contains the text of one or more articles. This data will be used to train the model and create an index for searching.

## Steps

### 1. **Data Preprocessing**
   - Extract relevant parts of Wikipedia articles.
   - Clean the text by removing unnecessary tags and templates.

### 2. **Indexing with Elasticsearch**
   - Set up an Elasticsearch index to store the processed articles.
   - Create a script to upload the JSON data into the Elasticsearch index.

### 3. **Building the NLP Model**
   - Use `spaCy` or `NLTK` to create a pipeline for synonym detection.
   - Train the model on the extracted data and adjust it for better synonym identification.

### 4. **Frontend Development**
   - Develop a simple web app using Flask or another framework.
   - Provide a text input for users to search for words and retrieve synonyms.
