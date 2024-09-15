package com.sat.springboottodoapplication.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Setter
@Getter
@RequiredArgsConstructor
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private Long authorId;
}
