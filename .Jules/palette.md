## 2024-07-25 - Keyboard Accessibility in Swing Forms
**Learning:** Unlike web forms, pressing 'Enter' in a text field does not automatically trigger the primary button in Java Swing.
**Action:** Use `getRootPane().setDefaultButton(button)` to enable standard keyboard submission UX, wrapping it in `SwingUtilities.invokeLater()` to prevent `NullPointerException`s during early component initialization.
