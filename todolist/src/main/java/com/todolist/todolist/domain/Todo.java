package com.todolist.todolist.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long todoId;

    private String content;

    private Boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}
