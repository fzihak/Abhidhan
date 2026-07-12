## 2026-07-12 - Swing Enter-to-Submit Default Behavior
**Learning:** In Java Swing, pressing 'Enter' in a text field does not automatically trigger the primary button like in web forms. The root pane's default button needs to be set explicitly. Using `SwingUtilities.invokeLater()` prevents NullPointerExceptions during early component initialization since the root pane might be null.
**Action:** Always set the default button on the root pane using `getRootPane().setDefaultButton(button)` wrapped in `invokeLater` for primary form actions.
