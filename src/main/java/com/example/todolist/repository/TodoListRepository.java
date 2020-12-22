package com.example.todolist.repository;

import java.util.UUID;

public interface TodoListRepository {

    boolean findByUUID(UUID uuid);
}
