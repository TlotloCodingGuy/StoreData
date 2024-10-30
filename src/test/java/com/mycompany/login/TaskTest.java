/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    // Test to check if a valid task description is accepted
    @Test
    public void testCheckTaskDescriptionSuccess() {
        Task task = new Task();
        // Assert that a valid description returns true
        assertTrue(task.checkTaskDescription("Task successfully captured."));
    }

    // Test to check if an invalid task description is rejected
    @Test
    public void testCheckTaskDescriptionFailure() {
        Task task = new Task();
        // Assert that an overly long description returns false
        assertFalse(task.checkTaskDescription("Please enter a task of less than 50 characters."));
    }

    // Test to validate Task ID generation based on task name and developer
    @Test
    public void testCreateTaskID() {
        Task task = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        // Generate the Task ID and assert it matches the expected format
        String taskID = task.createTaskID("Login Feature", "Robyn Harrison", 0);
        assertEquals("LO:0:HAR", taskID);
    }

    // Test to ensure the total hours for a list of tasks are calculated correctly
    @Test
    public void testReturnTotalHours() {
        List<Task> tasks = new ArrayList<>();
        
        // Create sample tasks and add them to the list
        Task task1 = new Task("Task 1", "Description 1", "Dev 1", 8, "To Do");
        Task task2 = new Task("Task 2", "Description 2", "Dev 2", 10, "Doing");
        
        tasks.add(task1);
        tasks.add(task2);

        // Sum the task durations and assert the total is correct
        int totalHours = tasks.stream().mapToInt(t -> t.taskDuration).sum();
        assertEquals(18, totalHours);
    }

    // Test to validate the total hours calculation for additional test data
    @Test
    public void testTotalHours_WithAdditionalData() {
        List<Task> tasks = new ArrayList<>();

        // Adding multiple tasks with varying durations
        tasks.add(new Task("Task 1", "Description 1", "Dev 1", 10, "To Do"));
        tasks.add(new Task("Task 2", "Description 2", "Dev 2", 12, "Doing"));
        tasks.add(new Task("Task 3", "Description 3", "Dev 3", 55, "Done"));
        tasks.add(new Task("Task 4", "Description 4", "Dev 4", 11, "To Do"));
        tasks.add(new Task("Task 5", "Description 5", "Dev 5", 1, "Doing"));

        // Calculate total hours and assert the expected result
        int totalHours = tasks.stream().mapToInt(t -> t.taskDuration).sum();
        assertEquals(89, totalHours);
    }
}

    