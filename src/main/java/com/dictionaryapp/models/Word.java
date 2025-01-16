package com.dictionaryapp.models;

import java.util.List;
import java.util.UUID;

public class Word {
    private String id;
    private String term;
    private String definition;
    private String bengaliDefinition;
    private List<String> synonyms;
    private String pronunciation;
    private String audioFile;
    private boolean isFavorite;
    private long lastAccessed;

    public Word() {
        this.id = UUID.randomUUID().toString();
        this.lastAccessed = System.currentTimeMillis();
    }

    public Word(String term, String definition, String bengaliDefinition) {
        this();
        this.term = term;
        this.definition = definition;
        this.bengaliDefinition = bengaliDefinition;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTerm() { return term; }
    public void setTerm(String term) { this.term = term; }

    public String getDefinition() { return definition; }
    public void setDefinition(String definition) { this.definition = definition; }

    public String getBengaliDefinition() { return bengaliDefinition; }
    public void setBengaliDefinition(String bengaliDefinition) { this.bengaliDefinition = bengaliDefinition; }

    public List<String> getSynonyms() { return synonyms; }
    public void setSynonyms(List<String> synonyms) { this.synonyms = synonyms; }

    public String getPronunciation() { return pronunciation; }
    public void setPronunciation(String pronunciation) { this.pronunciation = pronunciation; }

    public String getAudioFile() { return audioFile; }
    public void setAudioFile(String audioFile) { this.audioFile = audioFile; }

    public boolean isFavorite() { return isFavorite; }
    public void setFavorite(boolean favorite) { isFavorite = favorite; }

    public long getLastAccessed() { return lastAccessed; }
    public void setLastAccessed(long lastAccessed) { this.lastAccessed = lastAccessed; }

    @Override
    public String toString() {
        return "Word{" +
                "term='" + term + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}