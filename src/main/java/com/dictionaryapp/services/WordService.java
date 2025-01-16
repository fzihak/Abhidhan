package com.dictionaryapp.services;

import com.dictionaryapp.models.Word;
import com.dictionaryapp.database.SQLiteConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class WordService {
    private static final Logger LOGGER = Logger.getLogger(WordService.class.getName());
    private final Connection connection;

    public WordService() {
        this.connection = SQLiteConnection.getConnection();
    }

    public Word findWord(String term) {
        String sql = "SELECT * FROM words WHERE term = ? COLLATE NOCASE";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, term);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Word word = new Word();
                    word.setId(rs.getString("id"));
                    word.setTerm(rs.getString("term"));
                    word.setDefinition(rs.getString("definition"));
                    word.setBengaliDefinition(rs.getString("bengali_definition"));
                    word.setPronunciation(rs.getString("pronunciation"));
                    word.setAudioFile(rs.getString("audio_file"));
                    word.setFavorite(rs.getInt("is_favorite") == 1);
                    word.setLastAccessed(rs.getLong("last_accessed"));
                    
                    // Load synonyms
                    word.setSynonyms(findSynonyms(word.getId()));
                    
                    // Update last accessed time
                    updateLastAccessed(word.getId());
                    
                    // Log search in history
                    logSearch(term);
                    
                    return word;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error finding word: " + term, e);
        }
        return null;
    }

    private List<String> findSynonyms(String wordId) {
        List<String> synonyms = new ArrayList<>();
        String sql = "SELECT synonym FROM synonyms WHERE word_id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, wordId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    synonyms.add(rs.getString("synonym"));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error finding synonyms for word ID: " + wordId, e);
        }
        return synonyms;
    }

    private void updateLastAccessed(String wordId) {
        String sql = "UPDATE words SET last_accessed = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, System.currentTimeMillis());
            pstmt.setString(2, wordId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating last accessed time for word ID: " + wordId, e);
        }
    }

    private void logSearch(String term) {
        String sql = "INSERT INTO search_history (term) VALUES (?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, term);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error logging search for term: " + term, e);
        }
    }

    public void toggleFavorite(String wordId) {
        String sql = "UPDATE words SET is_favorite = CASE WHEN is_favorite = 1 THEN 0 ELSE 1 END WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, wordId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error toggling favorite status for word ID: " + wordId, e);
        }
    }

    public List<Word> getFavorites() {
        List<Word> favorites = new ArrayList<>();
        String sql = "SELECT * FROM words WHERE is_favorite = 1 ORDER BY last_accessed DESC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Word word = new Word();
                word.setId(rs.getString("id"));
                word.setTerm(rs.getString("term"));
                word.setDefinition(rs.getString("definition"));
                word.setBengaliDefinition(rs.getString("bengali_definition"));
                word.setPronunciation(rs.getString("pronunciation"));
                word.setAudioFile(rs.getString("audio_file"));
                word.setFavorite(true);
                word.setLastAccessed(rs.getLong("last_accessed"));
                word.setSynonyms(findSynonyms(word.getId()));
                favorites.add(word);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving favorite words", e);
        }
        return favorites;
    }
}