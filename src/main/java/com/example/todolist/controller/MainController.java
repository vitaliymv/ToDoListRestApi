package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MainController {

    private TaskService taskService = new TaskService();

    @GetMapping("/tasks")
    public @ResponseBody
    List<Task> getTodoList() {
        return taskService.getTasks();
    }

    @PostMapping(value = "/tasks")
    @ResponseBody
    public ResponseEntity addTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return new ResponseEntity(HttpStatus.OK, HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity deleteTask(@PathVariable UUID id) {
        try {
            taskService.removeTask(id);
        } catch (Exception e) {
            return new ResponseEntity("Not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Success", HttpStatus.OK);
    }

}
