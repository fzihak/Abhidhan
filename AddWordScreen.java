package com.abhidhan.dictionary.ui;

import javax.swing.*;
import java.awt.*;

public class AddWordScreen extends JDialog {
    private JTextField wordField;
    private JTextField meaningField;
    private JComboBox<String> languageComboBox;
    private JTextField synonymsField;
    private JTextField antonymsField;
    private JButton saveButton;
    private JButton cancelButton;
    private JPanel mainPanel;

    public AddWordScreen(JFrame parent) {
        super(parent, "Add New Word", true); // modal dialog
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(parent);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        Font banglaFont = new Font("SolaimanLipi", Font.PLAIN, 14); // Use a Bangla font

        // Word Field
        JLabel wordLabel = new JLabel("Word:");
        wordField = new JTextField(20);
        wordField.setFont(banglaFont);  // Set Bangla font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(wordLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(wordField, gbc);

        // Meaning Field
        JLabel meaningLabel = new JLabel("Meaning:");
        meaningField = new JTextField(20);
        meaningField.setFont(banglaFont); // Set Bangla font
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(meaningLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(meaningField, gbc);

        // Language Combo Box
        JLabel languageLabel = new JLabel("Language:");
        languageComboBox = new JComboBox<>(new String[]{"bn", "en"});
        languageComboBox.setFont(banglaFont); // Set Bangla font (for the dropdown items)
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(languageLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(languageComboBox, gbc);

        // Synonyms Field
        JLabel synonymsLabel = new JLabel("Synonyms (comma-separated):");
        synonymsField = new JTextField(20);
        synonymsField.setFont(banglaFont); // Set Bangla font
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(synonymsLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(synonymsField, gbc);

        // Antonyms Field
        JLabel antonymsLabel = new JLabel("Antonyms (comma-separated):");
        antonymsField = new JTextField(20);
        antonymsField.setFont(banglaFont); // Set Bangla font
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(antonymsLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(antonymsField, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        saveButton = new JButton("Save");
        saveButton.setFont(banglaFont); // Set font for buttons (optional, but consistent)
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(banglaFont);
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(buttonPanel, gbc);

        setContentPane(mainPanel);
        setResizable(false);
    }

    public JTextField getWordField() {
        return wordField;
    }

    public JTextField getMeaningField() {
        return meaningField;
    }

    public JComboBox<String> getLanguageComboBox() {
        return languageComboBox;
    }

    public JTextField getSynonymsField() {
        return synonymsField;
    }

    public JTextField getAntonymsField() {
        return antonymsField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }


    // Main method for testing the UI (optional, but good for development)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(); // Create a dummy JFrame for testing
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            AddWordScreen addWordScreen = new AddWordScreen(frame);
            addWordScreen.setVisible(true);
        });
    }
}