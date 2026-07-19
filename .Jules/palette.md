## 2024-07-19 - Java Swing Default Keyboard Submission UX
**Learning:** In Java Swing desktop apps (unlike standard web forms where hitting Enter automatically triggers the primary form submit button), pressing 'Enter' in a text field does not automatically trigger the default action unless explicitly configured.
**Action:** Use `getRootPane().setDefaultButton(button)` to enable standard keyboard submission UX, and wrap it in `SwingUtilities.invokeLater()` to prevent NullPointerExceptions during early UI initialization.
