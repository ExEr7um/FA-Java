package com.exer7um.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {
    private @Id @GeneratedValue(strategy=GenerationType.AUTO) Long id;
    private String login;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthday;

    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfUpdate;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    protected User() {}

    public User(String login) {
        this.login = login;
    }
}
