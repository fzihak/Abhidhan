package com.abhidhan.dictionary.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DictionaryDatabase {

    private static final String DB_URL = "jdbc:sqlite:src/main/java/com/abhidhan/dictionary/database/dictionary.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            String createWordTableSQL = "CREATE TABLE IF NOT EXISTS words (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    word TEXT NOT NULL,\n" +
                    "    meaning TEXT NOT NULL,\n" +
                    "    language TEXT NOT NULL,\n" +
                    "    synonyms TEXT,\n" +
                    "    antonyms TEXT\n" +
                    ")";
            statement.execute(createWordTableSQL);

            String createSuggestionTableSQL = "CREATE TABLE IF NOT EXISTS suggestions (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    word TEXT NOT NULL,\n" +
                    "    meaning TEXT NOT NULL,\n" +
                    "    language TEXT NOT NULL,\n" +
                    "    suggested_by TEXT,\n" +
                    "    status TEXT DEFAULT 'pending'\n" +
                    ")";
            statement.execute(createSuggestionTableSQL);

            String createFavoritesTableSQL = "CREATE TABLE IF NOT EXISTS favorites (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    word_id INTEGER NOT NULL,\n" +
                    "    user_id INTEGER,\n" +
                    "    FOREIGN KEY (word_id) REFERENCES words(id)\n" +
                    ")";
            statement.execute(createFavoritesTableSQL);

            System.out.println("Database and tables initialized (if not already exist).");

            // Load dictionary data
            DataImporter dataImporter = new DataImporter();
            dataImporter.loadDictionaryData();

        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}