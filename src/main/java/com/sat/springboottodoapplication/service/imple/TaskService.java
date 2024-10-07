package com.sat.springboottodoapplication.service.imple;

import com.sat.springboottodoapplication.DAO.impl.TaskRepo;
import com.sat.springboottodoapplication.DAO.model.Task;
import com.sat.springboottodoapplication.service.DTO.TaskDTO;
import com.sat.springboottodoapplication.service.mapper.TaskMapper;
import com.sat.springboottodoapplication.service.serviceInterface.ITaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private TaskMapper taskMapper;

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepo.findAll();
        List<TaskDTO> taskDTOS = new ArrayList<>();
        tasks.forEach(task -> {
            taskDTOS.add(taskMapper.toDto(task));
        });
        return taskDTOS;
    }

    public TaskService() {
    }

    public TaskDTO getTaskById(Long id) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskDTO> getTasksByCategory(String category) {
        List<Task> tasks = taskRepo.findAll();
        List<TaskDTO> categorizedTasks = new ArrayList<>();
        tasks.forEach( task -> {
            if (task.getCategory().getTitle().equals(category)){
                categorizedTasks.add(taskMapper.toDto(task));
            }
        });
        return categorizedTasks;
    }

    public TaskDTO saveTask (TaskDTO taskDTO) {
        taskRepo.save(taskMapper.toEntity(taskDTO));
//            log.info("Task with id: {} saved successfully", savedTask.getId());
        return taskDTO;
    }

    public TaskDTO updateTask (TaskDTO taskDTO) {
        Optional<Task> existingTask = taskRepo.findById(taskMapper.toEntity(taskDTO).getId());
        Task updatedTask = taskRepo.save(existingTask.get());

//        log.info("Task with id: {} updated successfully", updatedTask.getId());
        return taskMapper.toDto(updatedTask);
    }

    public void deleteTaskById (Long id) {
        taskRepo.deleteById(id);
    }
}
