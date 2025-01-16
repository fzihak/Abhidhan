package com.dictionaryapp.views;

import com.dictionaryapp.controllers.MainController;
import com.dictionaryapp.models.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame {
    private final MainController controller;
    private JTextField searchField;
    private JButton searchButton;
    private JButton favoriteButton;
    private JButton quizButton;
    private JTextArea definitionArea;
    private JTextArea bengaliDefinitionArea;
    private JList<String> synonymsList;
    private Word currentWord;
    private JButton pronunciationButton;
    private JToggleButton languageToggle;

    public MainView(MainController controller) {
        this.controller = controller;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Abhidhan - Dictionary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Main panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Top panel for search
        JPanel searchPanel = createSearchPanel();
        mainPanel.add(searchPanel, BorderLayout.NORTH);

        // Center panel for definitions
        JPanel definitionPanel = createDefinitionPanel();
        mainPanel.add(definitionPanel, BorderLayout.CENTER);

        // Right panel for synonyms
        JPanel synonymsPanel = createSynonymsPanel();
        mainPanel.add(synonymsPanel, BorderLayout.EAST);

        // Bottom panel for additional controls
        JPanel controlPanel = createControlPanel();
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        // Add menu bar
        setJMenuBar(createMenuBar());

        // Add main panel to frame
        add(mainPanel);

        // Add window listener for cleanup
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controller.shutdown();
            }
        });
    }

    private JPanel createSearchPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 0));
        searchField = new JTextField();
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchButton = new JButton("Search");
        
        panel.add(searchField, BorderLayout.CENTER);
        panel.add(searchButton, BorderLayout.EAST);
        
        return panel;
    }

    private JPanel createDefinitionPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        
        // English definition
        definitionArea = new JTextArea();
        definitionArea.setEditable(false);
        definitionArea.setLineWrap(true);
        definitionArea.setWrapStyleWord(true);
        JScrollPane englishScroll = new JScrollPane(definitionArea);
        englishScroll.setBorder(BorderFactory.createTitledBorder("English Definition"));
        
        // Bengali definition
        bengaliDefinitionArea = new JTextArea();
        bengaliDefinitionArea.setEditable(false);
        bengaliDefinitionArea.setLineWrap(true);
        bengaliDefinitionArea.setWrapStyleWord(true);
        JScrollPane bengaliScroll = new JScrollPane(bengaliDefinitionArea);
        bengaliScroll.setBorder(BorderFactory.createTitledBorder("Bengali Definition"));
        
        panel.add(englishScroll);
        panel.add(bengaliScroll);
        
        return panel;
    }

    private JPanel createSynonymsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        synonymsList = new JList<>(new DefaultListModel<>());
        JScrollPane scrollPane = new JScrollPane(synonymsList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Synonyms"));
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(200, 0));
        return panel;
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        
        favoriteButton = new JButton("★ Favorite");
        quizButton = new JButton("Start Quiz");
        pronunciationButton = new JButton("🔊 Pronounce");
        languageToggle = new JToggleButton("EN/বাং");
        
        panel.add(favoriteButton);
        panel.add(pronunciationButton);
        panel.add(quizButton);
        panel.add(languageToggle);
        
        return panel;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exportItem = new JMenuItem("Export Favorites");
        JMenuItem importItem = new JMenuItem("Import Data");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exportItem);
        fileMenu.add(importItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        // Settings Menu
        JMenu settingsMenu = new JMenu("Settings");
        JMenuItem preferencesItem = new JMenuItem("Preferences");
        JMenuItem syncItem = new JMenuItem("Sync Settings");
        settingsMenu.add(preferencesItem);
        settingsMenu.add(syncItem);
        
        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(settingsMenu);
        menuBar.add(helpMenu);
        
        return menuBar;
    }

    public void displayWord(Word word) {
        this.currentWord = word;
        definitionArea.setText(word.getDefinition());
        bengaliDefinitionArea.setText(word.getBengaliDefinition());
        
        DefaultListModel<String> model = new DefaultListModel<>();
        word.getSynonyms().forEach(model::addElement);
        synonymsList.setModel(model);
        
        updateFavoriteButton(word.isFavorite());
        pronunciationButton.setEnabled(word.getAudioFile() != null);
    }

    public void showMessage(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
    }

    // Getters
    public JTextField getSearchField() { return searchField; }
    public JButton getSearchButton() { return searchButton; }
    public JButton getFavoriteButton() { return favoriteButton; }
    public JButton getQuizButton() { return quizButton; }
    public Word getCurrentWord() { return currentWord; }

    public void updateFavoriteButton(boolean isFavorite) {
        favoriteButton.setText(isFavorite ? "★ Favorited" : "★ Favorite");
        favoriteButton.setForeground(isFavorite ? new Color(255, 215, 0) : Color.BLACK);
    }
}