/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
// Importing necessary libraries for the Swing framework and utility classes
import javax.swing.*;
import java.util.*;
import java.util.List;


/**
 *
 * @author RC_Student_lab
 */
public class Task {

    // Task properties
    String taskName; // Name of the task
    String taskDescription; // Description of the task
    String developerDetails; // Developer assigned to the task
    int taskDuration; // Duration of the task in hours
    private String taskStatus; // Current status of the task
    private int taskNumber; // Auto-generated task number
    private String taskID; // Auto-generated task ID
    // Static counter for generating unique task numbers
    private static int taskCounter = 0;
    
    // Constructor to initialize a new task
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskNumber = taskCounter++; // Increment and assign task number
        //this.taskID = createTaskID();     // Generate Task ID
        //checkTaskDescription(); // Validate task description
    }
    
    // Class-level variables to store a list of tasks and the total hours spent
    private List<Task> taskList;
    float totalHours;
    
    // Constructor for the Task class that initializes the taskList
    public Task() {
        this.taskList = new ArrayList<>();
    }
    
    // Method to check if the task description exceeds 50 characters
    public boolean checkTaskDescription(String description) {
        boolean valid = false;
        if (taskDescription.length() <= 50) {
            JOptionPane.showMessageDialog(null, "Task sucessfully captured");
            valid = true; // Description is valid
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            valid = false; // Description is too long
        }
        return valid;
    }
    
    // Method to create a unique Task ID
    public String createTaskID(String taskName, String developerDetails, int taskNumber) {
        String namePart = taskName.length() >= 2 ? taskName.substring(0, 2) : taskName.toUpperCase(); // First two letters of task name
        String developerPart = developerDetails.length() >= 3 ? developerDetails.substring(0, 3) : developerDetails.toUpperCase(); // First two letters of task name
        return namePart + ":" + taskNumber + ":" + developerPart; // Format: AA:0:XYZ
    }
    
    // Method to return the full details of the task
    public String printTaskDetails(Task task) {
        return "Task Status: " + task.taskStatus
                + "\nDeveloper Details: " + task.developerDetails
                + "\nTask Number: " + task.taskNumber
                + "\nTask Name: " + task.taskName
                + "\nTask Description: " + task.taskDescription
                + "\nTask ID: " + task.taskID
                + "\nDuration: " + task.taskDuration + " hours";
        
    }
    
    
    //Method to select the statuses
    public String Status(String taskStatus) {
        String status = "";
        boolean valid = false;

        while (!valid) {
            String input = JOptionPane.showInputDialog(null, "Select the option \n1) To Do \n2) Doing \n 3) Done");
            int choice = Integer.parseInt(input);
            
            switch (choice) {
                case 1:
                    taskStatus = "To Do";
                    valid = true;
                    break;
                case 2:
                    taskStatus = "Doing";
                    valid = true;
                    break;
                case 3:
                    taskStatus = "Done";
                    valid = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please enter 1, 2, or 3");
            }
        }
        return taskStatus;
    }
    
    
       // Gather task details from the user
    public void addTask() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of task?"));
        for (int k = 0; k < numTasks; k++) {
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description(max 50 characters");
            String developerDetails = JOptionPane.showInputDialog("Enter Developer Details(First Last name");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration(in hours):"));

            totalHours += taskDuration;

            int taskNumber = k++;
            String menu = Status(taskStatus);
            String taskStatus = createTaskID(taskName, developerDetails, taskNumber);
            
            // Create a new Task object and add it to the list
            Task newtaskmanager = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
            taskList.add(newtaskmanager);

            JOptionPane.showMessageDialog(null, "Task Details: \n " + printTaskDetails(newtaskmanager), "Task Status", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    // Static method to calculate the total hours of all tasks
    public static int returnTotalHours(ArrayList<Task> tasks) {
        int totalHours = 0; // Initialize total hours
        for (Task task : tasks) {
            totalHours += task.taskDuration; // Accumulate duration of each task
        }
        return totalHours; // Return the total
    }

    











    }



