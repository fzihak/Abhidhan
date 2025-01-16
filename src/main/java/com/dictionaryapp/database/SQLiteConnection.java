package com.dictionaryapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;

public class SQLiteConnection {
    private static final Logger LOGGER = Logger.getLogger(SQLiteConnection.class.getName());
    private static final String DB_PATH = "src/main/resources/database/dictionary.db";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
                initializeDatabase();
                LOGGER.info("Database connection established successfully");
            } catch (ClassNotFoundException | SQLException e) {
                LOGGER.log(Level.SEVERE, "Error connecting to database", e);
            }
        }
        return connection;
    }

    private static void initializeDatabase() {
        try (Statement statement = connection.createStatement()) {
            // Create words table
            statement.execute("""
                CREATE TABLE IF NOT EXISTS words (
                    id TEXT PRIMARY KEY,
                    term TEXT NOT NULL,
                    definition TEXT,
                    bengali_definition TEXT,
                    pronunciation TEXT,
                    audio_file TEXT,
                    is_favorite INTEGER DEFAULT 0,
                    last_accessed INTEGER,
                    created_at INTEGER DEFAULT (strftime('%s', 'now'))
                )
            """);

            // Create synonyms table
            statement.execute("""
                CREATE TABLE IF NOT EXISTS synonyms (
                    word_id TEXT,
                    synonym TEXT,
                    FOREIGN KEY (word_id) REFERENCES words(id),
                    PRIMARY KEY (word_id, synonym)
                )
            """);

            // Create search history table
            statement.execute("""
                CREATE TABLE IF NOT EXISTS search_history (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    term TEXT NOT NULL,
                    searched_at INTEGER DEFAULT (strftime('%s', 'now'))
                )
            """);

            LOGGER.info("Database tables initialized successfully");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error initializing database tables", e);
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                LOGGER.info("Database connection closed successfully");
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error closing database connection", e);
            }
        }
    }
}