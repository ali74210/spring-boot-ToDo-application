package com.sat.springboottodoapplication.DAO.model;


import jakarta.persistence.*;

@Entity
@Table(name = "categoryTable")
public class Category {
    @Id
    @SequenceGenerator(name = "category_sequence", sequenceName = "category_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    private Long id;
    private String title;
    private String description;

    public Category() {
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getId() {
        return id;
    }
}
