## 2024-10-25 - Java Swing Keyboard Accessibility
**Learning:** In Java Swing desktop applications, keyboard accessibility and screen reader support lack equivalent HTML ARIA attributes; they instead rely critically on `setToolTipText()` for descriptions and `setMnemonic()` for keyboard navigation.
**Action:** Always map unique mnemonics to interactive components (avoiding standard shortcuts like Alt+F for File menus) and provide descriptive tooltips to ensure UI controls are accessible to keyboard and screen-reader users.
