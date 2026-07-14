## 2024-07-14 - Fix Java Swing form submission on Enter

**Learning:** In Java Swing views, unlike web forms, pressing 'Enter' in a text field does not automatically trigger the primary button. The recommended accessibility pattern is to use `getRootPane().setDefaultButton(button)` to enable standard keyboard submission UX. Moreover, wrapping this call in `SwingUtilities.invokeLater()` is essential because the root pane might be null during early component initialization, preventing unexpected `NullPointerException`s.

**Action:** Always set the default button for primary forms/searches in Java Swing applications using `SwingUtilities.invokeLater(() -> getRootPane().setDefaultButton(primaryButton));` to ensure proper keyboard navigation.
