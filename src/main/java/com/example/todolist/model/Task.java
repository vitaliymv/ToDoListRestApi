package com.example.todolist.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Task {

    private UUID id = UUID.randomUUID();
    private LocalDateTime date = LocalDateTime.now();
    private String task;
    private boolean done;

}
