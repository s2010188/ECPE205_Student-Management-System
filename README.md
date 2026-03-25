# Student Management System - Java Swing Group Project

A simple **Student Management System** built with Java Swing.  
Data is stored **in-memory** using an `ArrayList` of `Student` objects (no database).

---

## Project Structure

```
JAVA GUI/
├── README.md
├── .gitignore
└── src/
    ├── app/
    │   └── MainFrame.java          ← App entry point (Student 2)
    ├── model/
    │   ├── Student.java            ← Data model (Student 1)
    │   └── DataStore.java          ← Shared data store (Student 1)
    └── panels/
        ├── DashboardPanel.java     ← Dashboard tab (Student 2)
        ├── AddStudentPanel.java    ← Add student form (Student 3)
        ├── ViewStudentsPanel.java  ← View all students table (Student 4)
        ├── SearchStudentPanel.java ← Search feature (Student 5)
        └── EditStudentPanel.java   ← Edit/delete feature (Student 4 or 5)
```

---

## Team Assignments

| Student   | Owns These Files                              | Responsibility                          |
|-----------|-----------------------------------------------|-----------------------------------------|
| Student 1 | `model/Student.java`, `model/DataStore.java`  | Data model, fields, validation, storage |
| Student 2 | `app/MainFrame.java`, `panels/DashboardPanel.java` | App shell, layout, styling, dashboard |
| Student 3 | `panels/AddStudentPanel.java`                 | Add student form and validation         |
| Student 4 | `panels/ViewStudentsPanel.java`, `panels/EditStudentPanel.java` | View list, edit, delete features |
| Student 5 | `panels/SearchStudentPanel.java`              | Search/filter functionality             |

> **Rule: Only edit files you own.** If you need something from another file (e.g., a new method in `DataStore`), ask that team member to add it. This avoids merge conflicts.

---

## How to Run

### Using the terminal:
```bash
cd "JAVA GUI"
# Compile all files
javac -d out src/model/*.java src/panels/*.java src/app/*.java

# Run the application
java -cp out app.MainFrame
```

### Using an IDE (VS Code, IntelliJ, Eclipse):
1. Open the `JAVA GUI` folder as a project.
2. Set `src` as the source root.
3. Run `app/MainFrame.java` as the main class.

---

## Git Collaboration Instructions

### First-Time Setup (One team member creates the repo)

```bash
cd "JAVA GUI"
git init
git add .
git commit -m "Initial boilerplate project"
# Create a repository on GitHub, then:
git remote add origin https://github.com/YOUR_TEAM/student-management-system.git
git branch -M main
git push -u origin main
```

### Each Team Member (Clone & Branch)

```bash
# 1. Clone the repository
git clone https://github.com/YOUR_TEAM/student-management-system.git
cd student-management-system

# 2. Create YOUR OWN branch (use your name or feature)
git checkout -b feature/student3-add-panel

# 3. Work on YOUR assigned files only

# 4. Stage, commit, and push your branch
git add .
git commit -m "Implement add student form with validation"
git push origin feature/student3-add-panel

# 5. Go to GitHub → Create a Pull Request → Ask a teammate to review → Merge
```

### Daily Workflow (Keep Your Branch Updated)

```bash
# Before starting work each day, pull the latest main
git checkout main
git pull origin main

# Switch back to your branch and merge latest main into it
git checkout feature/your-branch
git merge main

# Continue working...
```

---

## Rules to Minimize Conflicts

1. **Each student edits ONLY their assigned files** — never touch another student's panel.
2. **Use branches** — never push directly to `main`.
3. **Pull before you push** — always `git pull` before starting work.
4. **Communicate** — if you need a method added to `Student.java` or `DataStore.java`, message Student 1.
5. **Merge via Pull Requests** — use GitHub PRs so the team can review before merging.
6. **Commit often** — small, frequent commits are easier to merge than large ones.

---

## What Each Student Should Do

### Student 1 — Data Model
- [ ] Add more fields to `Student.java` (email, course, yearLevel, contactNumber)
- [ ] Add getters/setters for new fields
- [ ] Update `toTableRow()` to include new fields
- [ ] Add methods in `DataStore.java` as teammates request them (e.g., `searchByName()`, `updateStudent()`)
- [ ] Add sample data with the new fields

### Student 2 — Main Frame & Dashboard
- [ ] Customize window title, size, and icon in `MainFrame.java`
- [ ] Improve styling (colors, fonts, look-and-feel)
- [ ] Add a menu bar (File > Exit, Help > About)
- [ ] Make `DashboardPanel.java` show meaningful stats (total students, average age, etc.)
- [ ] Add a welcome banner or app logo

### Student 3 — Add Student Panel
- [ ] Add more input fields matching the Student model
- [ ] Add proper validation (required fields, valid email, age range)
- [ ] Improve form layout with better spacing and alignment
- [ ] Show success/error feedback
- [ ] Add a "Reset" button

### Student 4 — View & Edit/Delete Panels
- [ ] Add more columns to the table in `ViewStudentsPanel.java`
- [ ] Implement sorting by column header clicks
- [ ] Improve table styling (alternating row colors, column widths)
- [ ] Make `EditStudentPanel.java` fully functional (select → edit → save)
- [ ] Add confirmation dialogs for delete

### Student 5 — Search Panel
- [ ] Implement search/filter by multiple criteria (name, ID, course)
- [ ] Handle case-insensitive partial matching
- [ ] Display results in a JTable instead of text area
- [ ] Add "Clear Search" functionality
- [ ] Show a message when no results are found

---

## Important Notes

- **No database** is used. All data lives in `DataStore.java` as an `ArrayList`. Data resets when the app restarts.
- The `DataStore` uses the **Singleton pattern** — all panels share the same instance via `DataStore.getInstance()`.
- Each panel is a separate class in the `panels/` package, loaded as a tab in `MainFrame`.
- The boilerplate already works out of the box — compile and run to see the starting state.

---

## Grading **Checklist**

- [ ] Application compiles and runs without errors
- [ ] All 5 tabs/features are functional
- [ ] Proper input validation on forms
- [ ] Clean, readable code with proper naming
- [ ] Used Git branches and Pull Requests for collaboration
- [ ] Each team member contributed to their assigned files (visible in Git history)
