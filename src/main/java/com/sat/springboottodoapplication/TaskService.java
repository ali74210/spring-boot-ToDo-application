package com.sat.springboottodoapplication;

import com.sat.springboottodoapplication.model.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    @Autowired
    private final TasksDAO TaskRepo;

    public List<Task> getAllTasks(){
        return TaskRepo.findAll();
    }

    public Task getTaskById(Long id){
        Optional<Task> optionalTask = TaskRepo.findById(id);
        if(optionalTask.isPresent()){
            return optionalTask.get();
        }
        log.info("Task with id: {} doesn't exist", id);
        return null;
    }

    public Task saveTask (Task task){
        Task savedTask = TaskRepo.save(task);

        log.info("Task with id: {} saved successfully", task.getId());
        return savedTask;
    }

    public Task updateTask (Task task) {
        Optional<Task> existingTask = TaskRepo.findById(task.getId());
        Task updatedTask = TaskRepo.save(task);

        log.info("Task with id: {} updated successfully", task.getId());
        return updatedTask;
    }

    public void deleteTaskById (Long id) {
        TaskRepo.deleteById(id);
    }

}
