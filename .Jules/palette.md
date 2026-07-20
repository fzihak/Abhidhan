## 2024-05-24 - Java Swing Default Button NPE Fix
**Learning:** In Java Swing, setting the default button for the Enter key via `getRootPane().setDefaultButton(button)` can cause NullPointerExceptions if called during early component initialization, as the root pane might be null.
**Action:** Always wrap this call in `SwingUtilities.invokeLater()` to ensure it runs after the UI initialization is complete.
