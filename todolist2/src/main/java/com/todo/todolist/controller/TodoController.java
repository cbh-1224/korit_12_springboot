package com.todo.todolist.controller;

import com.todo.todolist.dto.TodoRequest;
import com.todo.todolist.dto.TodoResponse;
import com.todo.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/{userId}")
    public ResponseEntity<TodoResponse> addTodo(@PathVariable Long userId, @RequestBody TodoRequest request) {
        TodoResponse response = todoService.createTodo(userId, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        return ResponseEntity.ok(todoService.getTodoList());
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<TodoResponse> completeTodo(@PathVariable Long todoId) {
        return ResponseEntity.ok(todoService.completeToggle(todoId));
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.noContent().build();
    }


}
