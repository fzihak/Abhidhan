## 2026-06-25 - [Java Swing Default Button Handling]
**Learning:** In Java Swing desktop applications, pressing 'Enter' inside a text field does not naturally trigger the primary form button like it does in standard HTML web forms. This disrupts basic keyboard accessibility patterns.
**Action:** Use `getRootPane().setDefaultButton(button)` on the view's root pane to explicitly enable standard Enter-key submission UX.
