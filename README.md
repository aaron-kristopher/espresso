# ☕ Espresso

**Espresso** is a DIY text editor written in **Java**, built with **Maven**.
This project is primarily for **learning and exploration** — digging into how text editors work at the data-structure level, and extending that into a terminal-based editor.

---

## ✨ Features Implemented

* ✅ **Gap Buffer** data structure for efficient editing

  * Dynamic resizing
  * Character insertion
  * Gap movement (cursor positioning)
* ✅ Basic buffer visualization (`toString()`)

---

## 📝 Roadmap / TODO

* [ ] Deletion support (before and after cursor)
* [ ] Cursor movement abstraction
* [ ] Integration with [Lanterna](https://github.com/mabe02/lanterna) for terminal UI
* [ ] Line and word navigation
* [ ] Undo/redo support
* [ ] File I/O (open/save)
* [ ] Syntax highlighting (stretch goal)

---

## ⚙️ Tech Stack

* **Language:** Java 24 (OpenJDK 24.0.1)
* **Build Tool:** Maven

```bash
java --version
openjdk 24.0.1 2025-04-15
OpenJDK Runtime Environment (build 24.0.1)
OpenJDK 64-Bit Server VM (build 24.0.1, mixed mode, sharing)
```

---

## 🚀 Build & Run

Clone and build with Maven:

```bash
git clone https://github.com/yourusername/espresso.git
cd espresso
mvn clean compile
```

*(Usage examples to follow once core editor features are implemented.)*

---

## 📚 Learning Goals

Espresso is not just an editor — it’s a journey into:

* The design of **core data structures** like the GapBuffer
* How **text editors** manage efficient insertion, deletion, and navigation
* Building **terminal applications** in Java using Lanterna
* Practicing DIY software craftsmanship ✨

---

## 🏗️ Project Status

Espresso is still **early stage** — the focus is currently on getting the GapBuffer and editor internals solid before building a full UI.

