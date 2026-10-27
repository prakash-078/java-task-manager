
package com.practice.taskmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Task> tasks = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("=== Java Task Manager ===");

        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> addTask();
                case 2 -> listTasks();
                case 3 -> completeTask();
                case 4 -> deleteTask();
                case 5 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default ->
                    System.out.println("Please choose a number from 1 to 5.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. Add task");
        System.out.println("2. Display All Tasks");
        System.out.println("3. Mark task as completed");
        System.out.println("4. Delete task");
        System.out.println("5. Exit");
    }

    
private static void addTask() {
    System.out.print("Enter task title: ");
    String title = scanner.nextLine().trim();

    if (title.isEmpty()) {
        System.out.println("Task title cannot be empty.");
        return;
    }

    System.out.println("Choose priority:");
    System.out.println("1. High");
    System.out.println("2. Medium");
    System.out.println("3. Low");

    int choice = readInt("Enter priority (1-3): ");

    String priority;

    switch (choice) {
        case 1 -> priority = "High";
        case 2 -> priority = "Medium";
        case 3 -> priority = "Low";
        default -> {
            System.out.println("Invalid priority.");
            return;
        }
    }

    tasks.add(new Task(nextId++, title, priority));
    System.out.println("Task added successfully.");
}


    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet. Add one first.");
            return;
        }

        System.out.println("--- Your Tasks ---");

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void completeTask() {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks to complete.");
            return;
        }

        listTasks();
        int id = readInt("Enter the task ID to complete: ");
        Task task = findTaskById(id);

        if (task == null) {
            System.out.println("No task found with ID " + id + ".");
            return;
        }

        task.setCompleted(true);
        System.out.println("Task marked as completed.");
    }

    private static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks to delete.");
            return;
        }

        listTasks();
        int id = readInt("Enter the task ID to delete: ");
        Task task = findTaskById(id);

        if (task == null) {
            System.out.println("No task found with ID " + id + ".");
            return;
        }

        tasks.remove(task);
        System.out.println("Task deleted successfully.");
    }

    private static Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }

        return null;
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}


class Task {
    private final int id;
    private final String title;
    private final String priority;
    private boolean completed;

    public Task(int id, String title, String priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        String status = completed ? "Completed" : "Pending";

        return id + ". [" + status + "] "
                + title + " | Priority: " + priority;
    }
}
