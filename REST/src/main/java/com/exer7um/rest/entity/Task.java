package com.exer7um.rest.entity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Task {
    private @Id @GeneratedValue(strategy=GenerationType.AUTO) Long id;

    @Column(nullable=false)
    private String title;
    private String description;
    private LocalDateTime deadline;
    private boolean isCompleted;

    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfUpdate;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany(mappedBy = "tasks")
    private List<Category> categories;
}
