package com.abhidhan.dictionary.ui.controller;

import com.abhidhan.dictionary.backend.service.DictionaryService;
import com.abhidhan.dictionary.backend.model.Suggestion;
import com.abhidhan.dictionary.ui.SuggestWordScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuggestWordScreenController {

    private final SuggestWordScreen suggestWordScreen;
    private final DictionaryService dictionaryService;

    public SuggestWordScreenController(SuggestWordScreen suggestWordScreen, DictionaryService dictionaryService) {
        this.suggestWordScreen = suggestWordScreen;
        this.dictionaryService = dictionaryService;

        this.suggestWordScreen.getSuggestButton().addActionListener(new SuggestButtonListener());
        this.suggestWordScreen.getCancelButton().addActionListener(new CancelButtonListener());
    }

    class SuggestButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            suggestWord();
        }
    }

    class CancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            suggestWordScreen.dispose();
        }
    }

    private void suggestWord() {
        String word = suggestWordScreen.getWordField().getText().trim();
        String meaning = suggestWordScreen.getMeaningField().getText().trim();
        String language = (String) suggestWordScreen.getLanguageComboBox().getSelectedItem();

        if (word.isEmpty() || meaning.isEmpty() || language == null || language.isEmpty()) {
            JOptionPane.showMessageDialog(suggestWordScreen, "Word, meaning, and language are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a Suggestion object (we'll leave suggestedBy null for now)
        Suggestion newSuggestion = new Suggestion(word, meaning, language, null, "pending");

        try {
            dictionaryService.addSuggestion(newSuggestion);
            JOptionPane.showMessageDialog(suggestWordScreen, "Suggestion submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            suggestWordScreen.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(suggestWordScreen, "Error submitting suggestion: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}