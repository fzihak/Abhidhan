## 2024-05-18 - [Keyboard Submit in Swing]
**Learning:** In Java Swing, pressing Enter inside a text field does not trigger the primary button like it does in standard HTML forms. This is a common accessibility/UX pitfall where users expect Enter to submit but nothing happens.
**Action:** Use `getRootPane().setDefaultButton(button)` wrapped in `SwingUtilities.invokeLater()` to enable standard keyboard submission UX without risking NullPointerExceptions during early component initialization.
