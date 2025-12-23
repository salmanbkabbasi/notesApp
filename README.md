# StudyNotes & Quiz App

A comprehensive, Material 3-based Android application designed for efficient note-taking and interactive self-testing. This app leverages modern Android development practices, including the MVVM architecture and the Room Persistence Library, to provide a seamless and robust user experience.

---

## 🚀 Key Features

### 📝 Note Management (CRUD)
- **Create**: Add new study notes instantly through a modern, outlined Material input field.
- **Read**: View all your saved notes in an organized, scrollable list with smooth animations.
- **Update**: Tap on any existing note to modify its content. The UI intelligently switches to "Edit Mode."
- **Delete**: Remove notes with a dedicated delete button. Includes a confirmation dialog to prevent accidental deletions.

### 🧠 Interactive Quiz System
- **Multiple Choice**: Test your knowledge with dynamically generated questions and options.
- **Instant Feedback**: 
    - **Correct**: Selected option turns **Green** with a success message.
    - **Incorrect**: Selected option turns **Red**, and the correct answer is automatically highlighted in **Green**.
- **Progress Tracking**: Easily move through the question bank with a "Next" button that appears only after an attempt.

### 🎨 Modern UI & UX
- **Material Design 3 (M3)**: Built with the latest Material components (Cards, Surfaces, and Buttons).
- **Dark Theme Support**: First-class support for Dark Mode using semantic theme attributes. Text and backgrounds adapt automatically for high readability.
- **State Preservation**: Uses Android ViewModels and `onSaveInstanceState` to ensure your data (drafts, quiz progress) isn't lost during screen rotations or process death.

---

## 🛠 Technical Stack

- **Language**: Java 11
- **Architecture**: MVVM (Model-View-ViewModel) for clean separation of concerns.
- **Database**: **Room Persistence Library** (Abstraction over SQLite) for local data storage.
- **Components**:
    - `LiveData`: To observe data changes and update the UI reactively.
    - `ViewModel`: To manage UI-related data in a lifecycle-aware way.
    - `RecyclerView`: To efficiently render large lists of data.
    - `Material Components`: Using Google's `com.google.android.material` library for standard-compliant design.

---

## 📁 Project Structure & File Guide

The project is organized following clean architecture principles:

```text
D:/Notes/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/notes/
│   │   │   ├── database/             # Data Layer (Room)
│   │   │   │   ├── AppDatabase.java  # Singleton DB instance
│   │   │   │   ├── Note.java         # Entity representing a Note table
│   │   │   │   └── NoteDao.java      # Interface for DB operations (CRUD)
│   │   │   ├── ui/                   # View Layer (Activities & Adapters)
│   │   │   │   ├── MainActivity.java # Primary UI for note management
│   │   │   │   ├── QuizActivity.java # Interactive quiz interface
│   │   │   │   └── NoteAdapter.java  # Controller for Note items in RecyclerView
│   │   │   └── viewmodel/            # Logic Layer
│   │   │       └── NoteViewModel.java# Bridges DB operations and UI
│   │   ├── res/                      # Resource Files
│   │   │   ├── layout/               # XML Layout Definitions
│   │   │   │   ├── activity_main.xml # Main dashboard layout
│   │   │   │   ├── activity_quiz.xml # Quiz screen layout
│   │   │   │   └── note_item.xml     # Single note card layout
│   │   │   ├── values/               # Colors, Strings, and Themes
│   │   │   └── values-night/         # Dark Mode overrides
│   │   └── AndroidManifest.xml       # App manifest and activity declarations
├── build.gradle.kts                  # Project-level build configuration
├── settings.gradle.kts               # Module and repository configuration
└── gradle/libs.versions.toml         # Version Catalog for dependencies
```

---

## 📖 Installation & Usage

1. **Clone**: `git clone https://github.com/username/Notes.git`
2. **Open**: Launch Android Studio and open the project.
3. **Build**: Go to `Build > Make Project`.
4. **Usage**:
    - **Save Note**: Type your note and hit "Save Note".
    - **Edit Note**: Click on the text of any note in the list.
    - **Quiz**: Click the **Practice Quiz** button at the bottom center to start testing yourself.

---

## 🛡️ License

This project is licensed under the MIT License - see the LICENSE file for details.
