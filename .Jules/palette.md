## 2026-06-06 - Unique Keyboard Mnemonics in Swing
**Learning:** When adding keyboard mnemonics to Java Swing components, they must be unique within the same view to prevent navigation conflicts (e.g., avoiding disruption of standard OS shortcuts like Alt+F or conflicting items in the same menu).
**Action:** Always verify other mnemonics in the current window scope before assigning a new one to avoid breaking keyboard accessibility for power users.
