## 2024-07-08 - Keyboard Accessibility in Java Swing Views

**Learning:** In Java Swing views, unlike web forms, pressing 'Enter' in a text field does not automatically trigger the primary button. The standard keyboard submission UX must be enabled manually by setting the root pane's default button. Furthermore, this action must be wrapped in `SwingUtilities.invokeLater()` to prevent a `NullPointerException` because the root pane might be null during the early stages of component initialization.

**Action:** Always enable standard keyboard submission (Enter key to submit) in Java Swing search forms or dialogs by adding `SwingUtilities.invokeLater(() -> getRootPane().setDefaultButton(primaryButton));` during UI initialization.