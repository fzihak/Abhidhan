## 2024-07-22 - Java Swing Enter Key Submission UX
**Learning:** In Java Swing, pressing Enter in a text field doesn't automatically submit the form like in web apps.
**Action:** Use `getRootPane().setDefaultButton(button)` wrapped in `SwingUtilities.invokeLater()` to enable standard keyboard submission.
