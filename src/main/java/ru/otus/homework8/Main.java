package ru.otus.homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = generateTasks();
        System.out.println(getTasksByStatus(tasks, "In progress"));
    }

    public static List<Task> generateTasks() {
        List<Task> tasks = new ArrayList<Task>();
        tasks.add(new Task(1, "Water the plants", "To do"));
        tasks.add(new Task(2, "Go grocery shopping", "In progress"));
        tasks.add(new Task(3, "Write a report", "Done"));
        tasks.add(new Task(4, "Do the laundry", "To do"));
        tasks.add(new Task(5, "Clean the room", "In progress"));
        tasks.add(new Task(6, "Call parents", "Done"));
        tasks.add(new Task(7, "Read a book", "To do"));
        tasks.add(new Task(8, "Cook dinner", "In progress"));
        tasks.add(new Task(9, "Check email", "Done"));
        tasks.add(new Task(10, "Watch a series", "To do"));
        tasks.add(new Task(11, "Send an email to a colleague", "In progress"));
        tasks.add(new Task(12, "Do morning exercises", "Done"));
        tasks.add(new Task(13, "Plan a trip", "To do"));
        tasks.add(new Task(14, "Fix the bike", "In progress"));
        tasks.add(new Task(15, "Visit the doctor", "To do"));
        tasks.add(new Task(16, "Back up files", "In progress"));
        tasks.add(new Task(17, "Pay the bills", "Done"));
        tasks.add(new Task(18, "Prepare a presentation", "In progress"));
        tasks.add(new Task(19, "Buy a gift", "To do"));
        tasks.add(new Task(20, "Update software", "Done"));
        return tasks;
    }

    public static List<Task> getTasksByStatus (List<Task> tasks, String status) {
        return tasks.stream()
                .filter(t -> t.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}