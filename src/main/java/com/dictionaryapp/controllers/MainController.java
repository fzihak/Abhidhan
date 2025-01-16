package com.dictionaryapp.controllers;

import com.dictionaryapp.models.Word;
import com.dictionaryapp.models.User;
import com.dictionaryapp.services.WordService;
import com.dictionaryapp.views.MainView;

import javax.swing.*;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class MainController {
    private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());
    private final WordService wordService;
    private final MainView mainView;
    private User currentUser;

    public MainController() {
        this.wordService = new WordService();
        this.mainView = new MainView(this);
        initializeController();
    }

    private void initializeController() {
        // Initialize event listeners
        mainView.getSearchButton().addActionListener(e -> handleSearch());
        mainView.getFavoriteButton().addActionListener(e -> handleToggleFavorite());
        mainView.getQuizButton().addActionListener(e -> startQuiz());
        
        // Load user preferences
        loadUserPreferences();
    }

    private void handleSearch() {
        String searchTerm = mainView.getSearchField().getText().trim();
        if (!searchTerm.isEmpty()) {
            try {
                Word word = wordService.findWord(searchTerm);
                if (word != null) {
                    mainView.displayWord(word);
                    updateSearchHistory(searchTerm);
                } else {
                    mainView.showMessage("Word not found", "The word '" + searchTerm + "' was not found in the dictionary.");
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error searching for word: " + searchTerm, e);
                mainView.showError("Search Error", "An error occurred while searching for the word.");
            }
        }
    }

    private void handleToggleFavorite() {
        Word currentWord = mainView.getCurrentWord();
        if (currentWord != null) {
            try {
                wordService.toggleFavorite(currentWord.getId());
                boolean isFavorite = !currentWord.isFavorite();
                currentWord.setFavorite(isFavorite);
                mainView.updateFavoriteButton(isFavorite);
                
                // Update user's favorite words
                if (currentUser != null) {
                    if (isFavorite) {
                        currentUser.addFavoriteWord(currentWord.getId());
                    } else {
                        currentUser.removeFavoriteWord(currentWord.getId());
                    }
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error toggling favorite status", e);
                mainView.showError("Favorite Error", "An error occurred while updating favorite status.");
            }
        }
    }

    private void startQuiz() {
        List<Word> favoriteWords = wordService.getFavorites();
        if (favoriteWords.isEmpty()) {
            mainView.showMessage("Quiz", "Add some favorite words first to start a quiz!");
            return;
        }
        
        // Initialize and show quiz dialog
        SwingUtilities.invokeLater(() -> {
            // TODO: Implement Quiz Dialog
            mainView.showMessage("Quiz", "Quiz feature coming soon!");
        });
    }

    private void loadUserPreferences() {
        // TODO: Load user preferences from storage
        this.currentUser = new User();
    }

    private void updateSearchHistory(String searchTerm) {
        // TODO: Implement search history update
    }

    public void shutdown() {
        // Cleanup resources
        try {
            wordService.close();
            // Save user preferences
            // Close any open connections
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error during shutdown", e);
        }
    }

    // Getter for MainView
    public MainView getMainView() {
        return mainView;
    }
}