# StudyNotes & Quiz App

A modern, material-designed Android application for managing study notes and testing your knowledge with an interactive quiz. Built with Java and the latest Android Jetpack components.

## 📱 UI Preview

> **Note**: Add your screenshots to the `art/` folder and update the paths below to showcase your app!

| Main Notes Screen | Dark Mode Support | Interactive Quiz |
| :---: | :---: | :---: |
| ![Main Screen](https://via.placeholder.com/200x400?text=Main+Screen) | ![Dark Mode](https://via.placeholder.com/200x400?text=Dark+Mode) | ![Quiz Mode](https://via.placeholder.com/200x400?text=Quiz+Mode) |

### Design Highlights
- **Material 3 (M3)**: Utilizing Google's latest design system for a fresh, tactile feel.
- **Surface Colors**: Intelligent use of `colorSurface` and `colorOnSurface` for seamless light/dark transitions.
- **Dynamic Feedback**: Visual cues like stroke color changes (Green/Red) during the quiz for intuitive learning.

## ✨ Features

-   **Note Management**:
    -   **Create**: Quickly jot down study notes using an outlined Material TextField.
    -   **Read**: View all notes in elevated Material Cards.
    -   **Update**: Seamlessly edit existing notes by tapping the item.
    -   **Delete**: One-tap removal with a protective confirmation dialog.
-   **Interactive Quiz**:
    -   Multiple-choice questions with dynamic option generation.
    -   Instant validation with color-coded feedback.
    -   State-aware buttons that guide the user through the learning process.
-   **Modern UI/UX**:
    -   **Floating Action Buttons**: Primary actions (Quiz) are easily accessible.
    -   **Responsive Design**: Layouts adapt perfectly to screen rotation.

## 🛠 Tech Stack

-   **Language**: Java
-   **Architecture**: MVVM (Model-View-ViewModel)
-   **Database**: Room Persistence Library
-   **UI Components**:
    -   `MaterialCardView`, `ExtendedFloatingActionButton`, `TextInputLayout`
    -   `LiveData` & `ViewModel` for reactive UI updates.

## 📁 Project Structure

```text
com.example.notes/
├── database/          # Data Persistence (Room)
├── ui/                # Activities & Adapters (M3 UI)
└── viewmodel/         # Business Logic
```

## 🚀 Getting Started

1. **Clone & Open**: Open the project in the latest Android Studio.
2. **Build**: Ensure Gradle sync completes successfully.
3. **Run**: Deploy to an emulator or physical device (API 24+).

## 📝 Usage Guide

- **Note Entry**: Type and click **Save**.
- **Quiz**: Click the **Practice Quiz** FAB at the bottom.
- **Edit**: Tap any note to modify its content.

## 🛡️ License
MIT License
