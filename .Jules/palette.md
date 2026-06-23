## 2026-06-23 - Java Swing Form Submission UX
**Learning:** In Java Swing, pressing 'Enter' within a text field does not automatically submit a form or trigger the primary action as it does in web applications. This is a common accessibility/UX pitfall when transitioning web patterns to desktop apps.
**Action:** Always map the default action to the primary button in a view by using `getRootPane().setDefaultButton(button)`. For thread safety during component initialization, wrap this call in `SwingUtilities.invokeLater()`.
