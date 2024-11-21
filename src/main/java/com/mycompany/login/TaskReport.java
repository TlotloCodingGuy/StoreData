/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */



public class TaskReport {

    // Arrays to store task details
    private String[] developers;       // Stores developer names
    private String[] taskNames;        // Stores task names
    private String[] taskIDs;          // Stores task IDs
    private int[] taskDurations;       // Stores task durations in hours
    private String[] taskStatuses;     // Stores task statuses (e.g., To Do, Doing, Done)
    private int taskCount;             // Keeps track of the number of tasks added

    // Constructor to initialize arrays with a maximum task limit
    public TaskReport(int maxTasks) {
        developers = new String[maxTasks];
        taskNames = new String[maxTasks];
        taskIDs = new String[maxTasks];
        taskDurations = new int[maxTasks];
        taskStatuses = new String[maxTasks];
        taskCount = 0; // Initially, no tasks are added
    }

    // Method to add a new task to the arrays
    public void addTask(String developer, String taskName, int taskDuration, String taskStatus) {
        if (taskCount >= developers.length) {  // Check if the arrays are full
            JOptionPane.showMessageDialog(null, "Task list is full.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Add task details to the arrays
        developers[taskCount] = developer;
        taskNames[taskCount] = taskName;
        taskDurations[taskCount] = taskDuration;
        taskStatuses[taskCount] = taskStatus;

        // Generate a unique Task ID and add it to the taskIDs array
        taskIDs[taskCount] = generateTaskID(taskName, developer, taskCount);
        taskCount++;  // Increment task count
        JOptionPane.showMessageDialog(null, "Task successfully added!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to generate a unique Task ID using task name, developer name, and task number
    private String generateTaskID(String taskName, String developer, int taskNumber) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developer.substring(developer.length() - 3).toUpperCase();
    }

    // Method to display all tasks with the status "Done"
    public void displayTasksWithStatusDone() {
        StringBuilder result = new StringBuilder("Tasks with status 'Done':\n");
        for (int i = 0; i < taskCount; i++) {
            if (taskStatuses[i].equalsIgnoreCase("Done")) {
                result.append("Developer: ").append(developers[i]).append(", Task Name: ").append(taskNames[i]).append(", Duration: ").append(taskDurations[i]).append(" hrs\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.toString(), "Tasks with Status 'Done'", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to find and display the task with the longest duration
    public void displayLongestTask() {
        if (taskCount == 0) {  // Check if there are no tasks
            JOptionPane.showMessageDialog(null, "No tasks available.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int maxIndex = 0;  // Index of the task with the longest duration
        for (int i = 1; i < taskCount; i++) {
            if (taskDurations[i] > taskDurations[maxIndex]) {
                maxIndex = i;
            }
        }
        String message = "Longest Task: Developer: " + developers[maxIndex] + ", Duration: " + taskDurations[maxIndex] + " hrs";
        JOptionPane.showMessageDialog(null, message, "Longest Task", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to search for a task by its name and display its details
    public void searchTaskByName(String taskName) {
        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {  // Match task name ignoring case
                String message = "Task Found:\nTask Name: " + taskNames[i] + "\nDeveloper: " + developers[i] + "\nStatus: " + taskStatuses[i];
                JOptionPane.showMessageDialog(null, message, "Task Search", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to search for all tasks assigned to a specific developer and display them
    public void searchTasksByDeveloper(String developerName) {
        StringBuilder result = new StringBuilder("Tasks assigned to " + developerName + ":\n");
        boolean found = false;
        for (int i = 0; i < taskCount; i++) {
            if (developers[i].equalsIgnoreCase(developerName)) {
                result.append("Task Name: ").append(taskNames[i]).append(", Status: ").append(taskStatuses[i]).append("\n");
                found = true;
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(null, result.toString(), "Tasks by Developer", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for " + developerName, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to delete a task by its name and shift the remaining tasks in the arrays
    public void deleteTaskByName(String taskName) {
        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {  // Find the task to delete
                for (int j = i; j < taskCount - 1; j++) {  // Shift tasks left in the arrays
                    developers[j] = developers[j + 1];
                    taskNames[j] = taskNames[j + 1];
                    taskIDs[j] = taskIDs[j + 1];
                    taskDurations[j] = taskDurations[j + 1];
                    taskStatuses[j] = taskStatuses[j + 1];
                }
                taskCount--;  // Decrement the task count
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' deleted successfully.", "Task Deletion", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to display a full report of all tasks
    public void displayTaskReport() {
        StringBuilder report = new StringBuilder("Task Report:\n");
        for (int i = 0; i < taskCount; i++) {
            report.append("Task ID: ").append(taskIDs[i]).append("\n");
            report.append("Developer: ").append(developers[i]).append("\n");
            report.append("Task Name: ").append(taskNames[i]).append("\n");
            report.append("Duration: ").append(taskDurations[i]).append(" hrs\n");
            report.append("Status: ").append(taskStatuses[i]).append("\n");
            report.append("-----------------------------------\n");
        }
        JOptionPane.showMessageDialog(null, report.toString(), "Task Report", JOptionPane.INFORMATION_MESSAGE);
    }

    // Getters for unit testing purposes
    public String[] getTaskNames() {
        return taskNames.clone();
    }

    public String[] getDevelopers() {
        return developers.clone();
    }

    public int[] getTaskDurations() {
        return taskDurations.clone();
    }

    public int getTaskCount() {
        return taskCount;
    }
}


