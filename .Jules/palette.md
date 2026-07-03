## 2026-07-03 - Keyboard Submission UX in Java Swing
**Learning:** In Java Swing views, unlike web forms, pressing 'Enter' in a text field does not automatically trigger the primary button.
**Action:** Use `getRootPane().setDefaultButton(button)` to enable standard keyboard submission UX.
