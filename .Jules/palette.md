## 2024-03-28 - Enter to Submit in Swing Forms
**Learning:** In Java Swing, pressing 'Enter' in a text field does not automatically trigger the primary submission button as it does in standard web HTML forms.
**Action:** Use `SwingUtilities.invokeLater(() -> getRootPane().setDefaultButton(button));` in Swing views to mimic the standard web behavior and allow keyboard submission without requiring an explicit action listener on every text field.
