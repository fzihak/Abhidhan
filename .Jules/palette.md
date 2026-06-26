## 2026-06-26 - Enable Enter Key Submission in Swing Forms
**Learning:** In Java Swing, pressing the 'Enter' key inside a text field does not automatically trigger the primary button like it does in HTML web forms. This leads to a confusing UX where users type a query and press 'Enter' but nothing happens.
**Action:** Always set the default button for the view's root pane using `getRootPane().setDefaultButton(primaryButton)` to ensure seamless keyboard submission.
