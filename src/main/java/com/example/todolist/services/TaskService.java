package com.example.todolist.services;

import com.example.todolist.model.Task;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    public void saveTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void deleteTask(UUID id) {
        findByUUID(id);
    }

    public void findByUUID(UUID uuid) {

        for (Task task : getTasks()) {
            if(task.getId().toString().equals(uuid.toString())) {
                tasks.remove(task);
            }
        }
    }
}
