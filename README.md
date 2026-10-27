# Java Task Manager

A small beginner-friendly Java console application for practising Git and GitHub.

## Requirements
- Java JDK 17 or later
- A terminal or IDE such as VS Code

## Run the application

Open a terminal in this project folder.

### Windows
```cmd
javac -d out src\main\java\com\practice\taskmanager\Main.java
java -cp out com.practice.taskmanager.Main
```

### macOS / Linux
```bash
javac -d out src/main/java/com/practice/taskmanager/Main.java
java -cp out com.practice.taskmanager.Main
```

## Current features
1. Add a task
2. List all tasks
3. Mark a task as completed
4. Delete a task
5. Exit the application

Tasks are stored in memory, so they reset when the program exits. We can add file/database persistence later as a Git practice feature.

## Suggested Git practice path
- Create the first commit with the starter application.
- Add a due-date feature on a feature branch.
- Add task priorities on another branch.
- Open pull requests on GitHub and practise reviews.
- Intentionally create and resolve a merge conflict.
- Add automated tests and a GitHub Actions workflow.
