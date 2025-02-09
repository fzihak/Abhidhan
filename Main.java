package com.abhidhan.dictionary.main;

import com.abhidhan.dictionary.database.DictionaryDatabase;
import com.abhidhan.dictionary.ui.HomeScreen;

import javax.swing.*;
import java.awt.Font;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Use FlatLaf for a modern look and feel
                UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf()); // Or FlatDarkLaf(), FlatIntelliJLaf()

                // Set a default font that supports Bangla *globally* for the application.
                // This is a good fallback, but we'll also set it explicitly on components.
                Font defaultFont = new Font("SolaimanLipi", Font.PLAIN, 14); // Replace with YOUR font
                UIManager.put("defaultFont", defaultFont);

            } catch (Exception ex) {
                System.err.println("Failed to initialize FlatLaf Look and Feel");
                // Continue running even if L&F fails
            }

            DictionaryDatabase.initializeDatabase(); // Initialize database (creates tables and loads data)
            JFrame frame = new JFrame("Abhidhan");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new HomeScreen().getMainPanel());
            frame.pack();
            frame.setLocationRelativeTo(null); // Center the window
            frame.setVisible(true);
        });
    }
}