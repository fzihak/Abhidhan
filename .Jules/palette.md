## 2024-05-24 - Enable Enter Key Submission in Java Swing Views
**Learning:** In Java Swing applications, unlike web HTML forms where an input inside a form inherently supports "Enter" key submission, pressing 'Enter' in a `JTextField` does not automatically trigger the primary button. The application lacks built-in keyboard submission UX.
**Action:** When implementing primary search or submit actions in a Swing view, explicitly enable standard keyboard submission UX by using `getRootPane().setDefaultButton(button)` to map the "Enter" key to the primary action button.
