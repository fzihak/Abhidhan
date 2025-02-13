package com.abhidhan.dictionary.ui;

import com.abhidhan.dictionary.backend.service.DictionaryService;
import com.abhidhan.dictionary.ui.components.Footer;
import com.abhidhan.dictionary.ui.components.MenuBar;
import com.abhidhan.dictionary.ui.components.SearchBox;
import com.abhidhan.dictionary.ui.controller.SearchScreenController;
import com.abhidhan.dictionary.ui.controller.AddWordScreenController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class HomeScreen extends JPanel {
    private JPanel mainPanel;
    private JLabel logoLabel;
    private MenuBar menuBar;
    private SearchBox searchBox;
    private JPanel contentPanel;
    private Footer footer;
    private SearchScreenController controller;
    private DictionaryService dictionaryService;

    public HomeScreen() {
        mainPanel = new JPanel(new BorderLayout());
        dictionaryService = new DictionaryService();

        // --- Logo Loading ---
        logoLabel = new JLabel();
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        try {
            InputStream logoStream = getClass().getClassLoader().getResourceAsStream("dictionary/icons/logo.png");
            if (logoStream != null) {
                Image logoImage = ImageIO.read(logoStream);
                if (logoImage != null) {
                    Image scaledLogo = logoImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    logoLabel.setIcon(new ImageIcon(scaledLogo));
                } else {
                    logoLabel.setText("Logo Image Not Found");
                }
            } else {
                logoLabel.setText("Logo Resource Not Found");
            }
        } catch (IOException e) {
            logoLabel.setText("Error Loading Logo");
            e.printStackTrace();
        }
        mainPanel.add(logoLabel, BorderLayout.NORTH);

        // --- Menu Bar ---
        menuBar = new MenuBar();
        mainPanel.add(menuBar, BorderLayout.NORTH);

        // --- Search Box ---
        searchBox = new SearchBox();
        mainPanel.add(searchBox, BorderLayout.CENTER);

        // --- Content Panel ---
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        // For debugging, you could uncomment this to make the contentPanel visible even when empty:
        // contentPanel.setBackground(Color.YELLOW);
        mainPanel.add(contentPanel, BorderLayout.SOUTH);

        // --- Footer ---
        footer = new Footer();
        mainPanel.add(footer, BorderLayout.SOUTH);

        // --- Search Controller ---
        controller = new SearchScreenController(searchBox, contentPanel, dictionaryService, this);

        // --- Add Word Action ---
        menuBar.getAddWordItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(HomeScreen.this);
                AddWordScreen addWordScreen = new AddWordScreen(parentFrame);
                AddWordScreenController addWordController = new AddWordScreenController(addWordScreen, dictionaryService);
                addWordScreen.setVisible(true);
            }
        });

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }

    // Helper method to get the selected language
    public String getSelectedLanguage() {
        if (menuBar.getBnToEnItem().isSelected()) {
            return "bn"; // Bangla to English
        } else {
            return "en"; // English to Bangla (or default if neither is selected)
        }
    }

    public JPanel getMainPanel() {
        return this; // Return the HomeScreen itself (it's a JPanel)
    }
}