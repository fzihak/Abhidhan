## 2024-06-19 - Avoid Standard Mnemonics Conflicts
**Learning:** When adding mnemonics to Java Swing components, it is critical to ensure they are unique within the view to prevent keyboard navigation conflicts, such as avoiding 'Alt+F' for 'Favorite' since it typically disrupts standard shortcuts like 'File' menus.
**Action:** Always verify existing view-level shortcuts (including standard menus like File, Edit) before assigning new mnemonics to ensure non-disruptive keyboard accessibility.
