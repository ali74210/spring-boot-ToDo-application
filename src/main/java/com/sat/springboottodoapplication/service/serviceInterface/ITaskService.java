package com.sat.springboottodoapplication.service.serviceInterface;

import com.sat.springboottodoapplication.service.DTO.TaskDTO;
import java.util.List;

public interface ITaskService {

    List<TaskDTO> getAllTasks();
    TaskDTO getTaskById(Long id);
    TaskDTO saveTask (TaskDTO taskDTO);
    TaskDTO updateTask (TaskDTO taskDTO);
    void deleteTaskById (Long id);
    List<TaskDTO> getTasksByCategory(String category);

}
