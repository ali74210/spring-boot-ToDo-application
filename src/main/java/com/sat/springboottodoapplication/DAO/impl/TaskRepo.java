package com.sat.springboottodoapplication.DAO.impl;
import com.sat.springboottodoapplication.DAO.model.Category;
import com.sat.springboottodoapplication.DAO.model.Task;
import com.sat.springboottodoapplication.service.DTO.TaskDTO;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> getTasksByCategory(Category category);
}
