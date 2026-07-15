## 2026-07-15 - Java Swing Default Button
**Learning:** In Java Swing, pressing Enter in a text field doesn't automatically submit a form. You have to explicitly set a default button on the root pane using `getRootPane().setDefaultButton(button)`. This should be wrapped in `SwingUtilities.invokeLater` to ensure the root pane is fully initialized.
**Action:** Always verify keyboard accessibility in Java Swing apps. Set default buttons to enable standard Enter key submission UX.
