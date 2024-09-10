package com.sat.springboottodoapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    @Id
    private Long id; // change to long
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status; // annotation for saving on db
    @Enumerated(EnumType.ORDINAL)
    private Priority priority; // annotation for saving on db
    @ManyToOne
    private User author;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
