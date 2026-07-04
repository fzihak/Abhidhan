## 2026-07-04 - Enable Enter Key Form Submission in Java Swing
**Learning:** Unlike HTML forms where pressing 'Enter' in a text field often naturally triggers a submit event for the associated button, Java Swing components don't do this by default. This creates a break in expected keyboard navigation / form submission UX for users.
**Action:** Always enable standard keyboard submission UX by associating the primary action button to the window's root pane via `getRootPane().setDefaultButton(button)`.
