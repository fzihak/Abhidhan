package com.abhidhan.dictionary.ui;

import javax.swing.*;
import java.awt.*;

public class SuggestWordScreen extends JDialog {
    private JTextField wordField;
    private JTextField meaningField;
    private JComboBox<String> languageComboBox;
    private JButton suggestButton;
    private JButton cancelButton;
    private JPanel mainPanel;

    public SuggestWordScreen(JFrame parent) {
        super(parent, "Suggest New Word", true); // modal
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 250); // Smaller size, as fewer fields
        setLocationRelativeTo(parent);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        Font banglaFont = new Font("SolaimanLipi", Font.PLAIN, 14); // Use a Bangla font

        // Word Field
        JLabel wordLabel = new JLabel("Word:");
        wordField = new JTextField(20);
        wordField.setFont(banglaFont);
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
        meaningField.setFont(banglaFont);
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
        languageComboBox.setFont(banglaFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(languageLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(languageComboBox, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        suggestButton = new JButton("Suggest");
        suggestButton.setFont(banglaFont); //Consistent Font
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(banglaFont); //Consistent Font
        buttonPanel.add(suggestButton);
        buttonPanel.add(cancelButton);
        gbc.gridx = 0;
        gbc.gridy = 3; // Adjusted y position
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(buttonPanel, gbc);

        setContentPane(mainPanel);
        setResizable(false);
    }

    public JTextField getWordField() { return wordField; }
    public JTextField getMeaningField() { return meaningField; }
    public JComboBox<String> getLanguageComboBox() { return languageComboBox; }
    public JButton getSuggestButton() { return suggestButton; }
    public JButton getCancelButton() { return cancelButton; }


    // Main method for testing the UI (optional, but good for development)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(); // Create a dummy JFrame for testing
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            SuggestWordScreen addWordScreen = new SuggestWordScreen(frame);
            addWordScreen.setVisible(true);
        });
    }
}