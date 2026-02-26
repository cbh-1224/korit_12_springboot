package com.todo.todolist.service;

import com.todo.todolist.dto.TodoRequest;
import com.todo.todolist.dto.TodoResponse;
import com.todo.todolist.entity.Todo;
import com.todo.todolist.entity.User;
import com.todo.todolist.repository.TodoRepository;
import com.todo.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public TodoResponse createTodo(Long userId, TodoRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        Todo todo = new Todo(request.content(), user);
        Todo savedTodo = todoRepository.save(todo);

        return new TodoResponse(savedTodo.getId(), savedTodo.getContent(), savedTodo.isCompleted());
    }

    @Transactional(readOnly = true)
    public List<TodoResponse> getTodoList() {
        return todoRepository.findAll().stream()
                .map(todo -> new TodoResponse(todo.getId(), todo.getContent(), todo.isCompleted()))
                .collect(Collectors.toList());
    }

    @Transactional
    public TodoResponse completeToggle(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("할일을 찾을 수 없습니다."));

        todo.setCompleted(true);

        return new TodoResponse(
                todo.getId(),
                todo.getContent(),
                todo.isCompleted());
    }

    @Transactional
    public void deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("할일을 찾을 수 없습니다."));

        todoRepository.delete(todo);
    }
}
