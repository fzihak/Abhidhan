## 2026-06-04 - Tooltips and Keyboard Accessibility
**Learning:** Adding tooltips to icon-only buttons or complex toggles in Java Swing provides essential context, especially since standard buttons lack built-in accessibility descriptions. Mapping the 'Enter' key to a primary action like search significantly improves keyboard-driven workflows.
**Action:** Always check if primary input flows can be optimized with `setDefaultButton()` in Swing applications and add `setToolTipText()` for contextual hints on controls.
