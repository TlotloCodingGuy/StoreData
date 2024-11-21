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
public class TaskStoredMain {
    public static void main(String[] args) {
        TaskReport taskReport = new TaskReport(10);  // Initialize with capacity for 10 tasks

        // Options for the menu displayed to the user
        String[] options = {"Add Task", "Display 'Done' Tasks", "Longest Task", "Search by Name", "Search by Developer", "Delete Task", "Task Report", "Exit"};
        int choice;

        do {
            // Display menu using JOptionPane
            choice = JOptionPane.showOptionDialog(null, "Choose an option", "Task Manager",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Add Task
                    String developer = JOptionPane.showInputDialog("Enter Developer Name:");
                    String taskName = JOptionPane.showInputDialog("Enter Task Name:");
                    int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
                    String taskStatus = JOptionPane.showInputDialog("Enter Task Status (To Do / Doing / Done):");
                    taskReport.addTask(developer, taskName, taskDuration, taskStatus);
                    break;

                case 1: // Display 'Done' Tasks
                    taskReport.displayTasksWithStatusDone();
                    break;

                case 2: // Longest Task
                    taskReport.displayLongestTask();
                    break;

                case 3: // Search by Name
                    String searchName = JOptionPane.showInputDialog("Enter Task Name to Search:");
                    taskReport.searchTaskByName(searchName);
                    break;

                case 4: // Search by Developer
                    String searchDeveloper = JOptionPane.showInputDialog("Enter Developer Name to Search:");
                    taskReport.searchTasksByDeveloper(searchDeveloper);
                    break;

                case 5: // Delete Task
                    String deleteName = JOptionPane.showInputDialog("Enter Task Name to Delete:");
                    taskReport.deleteTaskByName(deleteName);
                    break;

                case 6: // Task Report
                    taskReport.displayTaskReport();
                    break;

                case 7: // Exit
                    JOptionPane.showMessageDialog(null, "Exiting Task Manager. Goodbye!", "Exit", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (choice != 7);  // Exit when the user selects "Exit"
    }
}

        
