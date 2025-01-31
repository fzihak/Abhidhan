﻿# Abhidhan

Abhidhan (অভিধান) is a versatile and feature-rich offline and online dictionary application that serves as your ultimate language companion. With advanced functionalities, it goes beyond being a simple dictionary by offering tools to enhance your vocabulary and make learning engaging and fun.

---

## Features

### 🌟 **Core Features:**
- **Word Search:** Quickly look up word meanings, synonyms, and pronunciations.
- **Offline Mode:** Access the dictionary anytime, even without internet connectivity.
- **Online Sync:** Sync with an online database for the latest word updates and definitions.

### 📚 **Learning Features:**
- **Daily Word:** Get daily word notifications to learn something new every day.
- **Quizzes:** Test your vocabulary skills with interactive word quizzes.
- **Favorites:** Save words to your personalized favorites list for easy access.
- **Word History:** View your recently searched words for quick reference.

### 🔒 **Utility Features:**
- **Data Backup & Restore:** Backup your favorite words and progress, and restore them anytime.
- **Multi-Language Support:** Switch between languages seamlessly (e.g., English, Bangla).
- **Audio Pronunciations:** Hear the correct pronunciation of words.
- **Theme Customization:** Personalize the app with light or dark themes.
- **Keyboard Shortcuts:** Use intuitive shortcuts for faster navigation.

---

## Technologies Used

### 💻 **Backend:**
- Java (Core and Advanced)
- SQLite (Local database)
- REST APIs for online functionalities

### 🖥️ **Frontend:**
- Java Swing (Graphical User Interface)
- FXML for layout management

### 🔧 **Utilities:**
- JSON for data parsing
- Logger for application logs

---

## Folder Structure

```plaintext
Abhidhan/
├── README.md
├── pom.xml or build.gradle
├── .gitignore
├── logs/
│   └── app.log
├── lib/
├── docs/
└── src/
    ├── main/
    │   ├── java/
    │   │   ├── com/
    │   │   │   └── dictionaryapp/
    │   │   │       ├── controllers/
    │   │   │       ├── models/
    │   │   │       ├── services/
    │   │   │       ├── database/
    │   │   │       ├── utils/
    │   │   │       └── views/
    │   ├── resources/
    │   │   ├── assets/
    │   │   ├── fxml/
    │   │   ├── i18n/
    │   │   └── database/
    └── test/
        └── java/
            └── com/
                └── dictionaryapp/
                    └── tests/
```

---

## Installation

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- SQLite installed (for local database management)
- IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans)

### Steps
1. Clone this repository:
   ```bash
   git clone https://github.com/fzihak/Abhidhan.git
   ```
2. Open the project in your preferred IDE.
3. Build the project using Maven or Gradle.
4. Run the application from the `MainController` class.

---

## Usage
- Launch the application and use the search bar to look up words.
- Enable offline mode to access saved word data without internet.
- Take vocabulary quizzes or explore the daily word feature for learning.

---

## Contribution

Contributions are welcome! Please follow these steps:
1. Fork this repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add some feature"
   ```
4. Push to the branch:
   ```bash
   git push origin feature-name
   ```
5. Create a Pull Request.

---

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Acknowledgments
- Inspired by the need for accessible, offline learning tools.
- Thanks to all contributors and testers who make this project possible.

---

Happy learning with **Abhidhan**! 🌟

