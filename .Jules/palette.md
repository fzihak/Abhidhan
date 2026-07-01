## 2026-07-01 - Java Swing Keyboard Submission UX
**Learning:** In Java Swing views, unlike web forms, pressing 'Enter' in a text field does not automatically trigger the primary button. This breaks standard keyboard accessibility expectations for search and submission forms.
**Action:** Use `getRootPane().setDefaultButton(button)` in the view initialization to map the Enter key to the primary action button for the view.
