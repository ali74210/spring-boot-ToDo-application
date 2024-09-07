package com.sat.springboottodoapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private User author;

    public Task(String title, String description, User author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public Task(Long id, String title, String description, Status status, Priority priority, User author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.author = author;
    }

    public Task() {

    }

    public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public User getAuthor() {
                return author;
            }

            public void setAuthor(User author) {
                this.author = author;
            }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
