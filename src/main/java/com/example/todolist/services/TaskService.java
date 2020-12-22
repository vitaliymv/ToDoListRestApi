package com.example.todolist.services;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService implements TodoListRepository{

    private List<Task> tasks = new ArrayList<>();
    public void saveTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void removeTask(UUID id) {
       findByUUID(id);
    }

    @Override
    public boolean findByUUID(UUID uuid) {
        return getTasks().
                removeIf(
                        task -> task.getId().
                                toString().equals(uuid.toString())
                );
    }
}
