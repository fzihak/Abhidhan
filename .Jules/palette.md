## 2026-07-02 - Setting Default Button for Forms in Java Swing
**Learning:** In Java Swing, pressing 'Enter' in a text field doesn't automatically trigger the main form action. Screen readers also benefit from explicit tooltips on text inputs and buttons.
**Action:** Use getRootPane().setDefaultButton(button) on the main view frame, and always set setToolTipText() for better accessibility.
