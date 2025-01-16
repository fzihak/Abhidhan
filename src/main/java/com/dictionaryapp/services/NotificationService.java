package com.dictionaryapp.services;

import com.dictionaryapp.models.Word;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import java.util.logging.Level;

public class NotificationService {
    private static final Logger LOGGER = Logger.getLogger(NotificationService.class.getName());
    private final WordService wordService;
    private Timer notificationTimer;
    private static final long NOTIFICATION_INTERVAL = 24 * 60 * 60 * 1000; // 24 hours

    public NotificationService(WordService wordService) {
        this.wordService = wordService;
        this.notificationTimer = new Timer(true);
    }

    public void startDailyNotifications() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                showWordOfTheDay();
            }
        };

        // Schedule the task to run daily
        notificationTimer.scheduleAtFixedRate(task, 0, NOTIFICATION_INTERVAL);
    }

    public void stopNotifications() {
        if (notificationTimer != null) {
            notificationTimer.cancel();
            notificationTimer = null;
        }
    }

    private void showWordOfTheDay() {
        try {
            if (SystemTray.isSupported()) {
                Word wordOfTheDay = wordService.getRandomWord();
                if (wordOfTheDay != null) {
                    displayTrayNotification(
                        "Word of the Day",
                        wordOfTheDay.getTerm() + ": " + wordOfTheDay.getDefinition()
                    );
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error showing word of the day notification", e);
        }
    }

    private void displayTrayNotification(String title, String message) {
        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("src/main/resources/assets/icon.png");
            TrayIcon trayIcon = new TrayIcon(image, "Abhidhan");
            trayIcon.setImageAutoSize(true);
            tray.add(trayIcon);
            trayIcon.displayMessage(title, message, TrayIcon.MessageType.INFO);
        } catch (AWTException e) {
            LOGGER.log(Level.SEVERE, "Error displaying system tray notification", e);
        }
    }
}