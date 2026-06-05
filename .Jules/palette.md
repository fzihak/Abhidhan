## 2024-06-05 - Missing keyboard mnemonics in Swing Menus
**Learning:** Java Swing menus in the app lack keyboard mnemonics (e.g., Alt+F for File menu), reducing accessibility for power users and screen reader navigation.
**Action:** Implemented mnemonics using `setMnemonic(KeyEvent.VK_*)` in `MainView.java`'s menus. Will check and add these to any future menus in other views.
