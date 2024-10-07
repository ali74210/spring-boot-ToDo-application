package com.sat.springboottodoapplication.DAO.model;

import com.sat.springboottodoapplication.DAO.model.enums.Priority;
import com.sat.springboottodoapplication.DAO.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Slf4j
@Table(name = "taskTable")
public class Task {
    @Id
    @SequenceGenerator(name = "task_sequence", sequenceName = "task_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    private Long id;

    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status; // annotation for saving on db
    @Enumerated(EnumType.ORDINAL)
    private Priority priority; // annotation for saving on db
    @ManyToOne
    private Category category;
    @ManyToOne
    private User author;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
