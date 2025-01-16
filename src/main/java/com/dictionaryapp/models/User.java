package com.dictionaryapp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String id;
    private String username;
    private String email;
    private List<String> favoriteWords;
    private UserSettings settings;
    private long lastSyncTimestamp;

    public User() {
        this.id = UUID.randomUUID().toString();
        this.favoriteWords = new ArrayList<>();
        this.settings = new UserSettings();
        this.lastSyncTimestamp = System.currentTimeMillis();
    }

    // Nested UserSettings class
    public static class UserSettings {
        private boolean notificationsEnabled;
        private String preferredLanguage; // "en" or "bn"
        private boolean autoSync;
        private boolean darkMode;

        public UserSettings() {
            this.notificationsEnabled = true;
            this.preferredLanguage = "en";
            this.autoSync = true;
            this.darkMode = false;
        }

        // Getters and Setters
        public boolean isNotificationsEnabled() { return notificationsEnabled; }
        public void setNotificationsEnabled(boolean notificationsEnabled) {
            this.notificationsEnabled = notificationsEnabled;
        }

        public String getPreferredLanguage() { return preferredLanguage; }
        public void setPreferredLanguage(String preferredLanguage) {
            this.preferredLanguage = preferredLanguage;
        }

        public boolean isAutoSync() { return autoSync; }
        public void setAutoSync(boolean autoSync) { this.autoSync = autoSync; }

        public boolean isDarkMode() { return darkMode; }
        public void setDarkMode(boolean darkMode) { this.darkMode = darkMode; }
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<String> getFavoriteWords() { return favoriteWords; }
    public void setFavoriteWords(List<String> favoriteWords) {
        this.favoriteWords = favoriteWords;
    }

    public UserSettings getSettings() { return settings; }
    public void setSettings(UserSettings settings) { this.settings = settings; }

    public long getLastSyncTimestamp() { return lastSyncTimestamp; }
    public void setLastSyncTimestamp(long lastSyncTimestamp) {
        this.lastSyncTimestamp = lastSyncTimestamp;
    }

    // Helper methods
    public void addFavoriteWord(String wordId) {
        if (!favoriteWords.contains(wordId)) {
            favoriteWords.add(wordId);
        }
    }

    public void removeFavoriteWord(String wordId) {
        favoriteWords.remove(wordId);
    }
}