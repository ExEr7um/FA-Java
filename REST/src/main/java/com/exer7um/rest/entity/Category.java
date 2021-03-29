package com.exer7um.rest.entity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Category {
    private @Id @GeneratedValue(strategy=GenerationType.AUTO) Long id;
    private String title;

    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfUpdate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "task_category",
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id",
                    referencedColumnName = "id"))
    private List<Task> tasks;
}
