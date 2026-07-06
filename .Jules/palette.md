## 2024-05-18 - [Fix Java Swing Default Button Behavior]
**Learning:** In Java Swing, pressing 'Enter' in a text field doesn't trigger the primary button like it does in web forms. You have to explicitly set the default button on the root pane (`getRootPane().setDefaultButton()`). Furthermore, doing this early in initialization might cause a NullPointerException because the root pane could be null.
**Action:** Use `SwingUtilities.invokeLater()` to set the default button on the root pane safely to enable standard keyboard submission UX.
