## 2024-07-01 - Add Enter Key Submission to Search Form
**Learning:** In Java Swing applications, unlike standard web forms, pressing 'Enter' within a text field does not automatically submit the form or trigger the primary action.
**Action:** Use `getRootPane().setDefaultButton(button)` to enable standard keyboard submission UX for primary actions in a view.
