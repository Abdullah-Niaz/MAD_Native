**Android Activity Lifecycle**:  

```plaintext
            +------------------+
            |   onCreate()      |  → Activity is created
            +------------------+
                     ↓
            +------------------+
            |    onStart()      |  → Activity becomes visible
            +------------------+
                     ↓
            +------------------+
            |   onResume()      |  → Activity is now interactive
            +------------------+
                     ↓
      App goes into background (Home button, new activity starts)
                     ↓
            +------------------+
            |   onPause()       |  → Activity is partially visible
            +------------------+
                     ↓
            +------------------+
            |    onStop()       |  → Activity is no longer visible
            +------------------+
                     ↓
    (App is reopened)        (User closes the app)
       ↓                        ↓
+------------------+       +------------------+
|   onRestart()    |       |  onDestroy()     |  → Activity is destroyed
+------------------+       +------------------+
       ↓
+------------------+
|    onStart()     |  → Activity restarts
+------------------+
       ↓
+------------------+
|   onResume()     |  → Activity is interactive again
+------------------+
```

---

### **📌 Explanation**
1. **`onCreate()`** → Activity is first created.
2. **`onStart()`** → Activity becomes visible.
3. **`onResume()`** → Activity starts interacting with the user.
4. **`onPause()`** → Activity is partially visible (e.g., user opens another app).
5. **`onStop()`** → Activity is completely hidden.
6. **`onRestart()`** → If the user returns to the app from the background.
7. **`onDestroy()`** → When the activity is completely removed from memory.

---

### **📌 How to Test This?**
- **Launch the app** → `onCreate()`, `onStart()`, `onResume()`
- **Press the Home button** → `onPause()`, `onStop()`
- **Reopen the app** → `onRestart()`, `onStart()`, `onResume()`
- **Swipe the app away from recent apps** → `onDestroy()`

---
