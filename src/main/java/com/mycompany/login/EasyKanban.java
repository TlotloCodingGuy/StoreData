/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
import javax.swing.*;
import java.util.ArrayList;


/**
 *
 * @author RC_Student_lab
 */
public class EasyKanban {
    
    public static void main(String[] args) {
        // Display a welcome message to the user
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        
        // Ask the user how many tasks they want to enter
       int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));
        Task newtask = new Task();
        // Loop until the user has entered the specified number of task
        boolean quit = false;
        while (!quit) {
            // Display menu options for the user
            int menu = Integer.parseInt(JOptionPane.showInputDialog(null,"Choose an option:\n 1) Add tasks\n 2) Show report (Coming Soon)\n3) Quit" ) );
            
            // Process user choice using switch-case
            switch (menu) {
                case 1:
                    // Add a new task
                    newtask.addTask();
                    break;
                case 2:
                    // Show a placeholder message for the report feature
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case 3:
                    // Exit the application
                    
                    JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban!");
                    return; // End the program
                default:
                    
            

                    // Handle invalid menu option
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                    break;
                    
                    
                  
            }
        }
    }
}
        
            
            







        
    
    
            
