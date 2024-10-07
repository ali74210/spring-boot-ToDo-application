package com.sat.springboottodoapplication.control.task;

import com.sat.springboottodoapplication.service.DTO.TaskDTO;
import com.sat.springboottodoapplication.service.serviceInterface.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/task/v1")
public class TaskController {

    @Autowired
    private ITaskService itaskService;

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/task/v1/
     * Purpose: Fetches all the tasks in the task table
     * @return List of tasks
     */
    @GetMapping("/")
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        return ResponseEntity.ok().body(itaskService.getAllTasks());
    }

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/task/v1/1 (or any other id)
     * Purpose: Fetches task with the given id
     * @param id - task id
     * @return task with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(itaskService.getTaskById(id));
    }

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/tasks/v1/work (or any other category)
     * Purpose: Fetches tasks with the given category
     * @param category - tasks category
     * @return List of tasks with the given category
     */
    @GetMapping("/Cat/{category}")
    public ResponseEntity<List<TaskDTO>> getTasksByCategory(@PathVariable String category)
    {
        return ResponseEntity.ok().body(itaskService.getTasksByCategory(category));
    }

    /**
     * This method is called when a POST request is made
     * URL: localhost:8080/task/v1/
     * Purpose: Save a Task entity
     * @param task - Request body is a Task entity
     * @return Saved Task entity
     */
    @PostMapping("")
    public ResponseEntity<TaskDTO> saveTask(@RequestBody TaskDTO task)
    {
        return ResponseEntity.ok().body(itaskService.saveTask(task));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/task/v1/
     * Purpose: Update a Task entity
     * @param task - Task entity to be updated
     * @return Updated Task
     */
    @PutMapping("/")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO task)
    {
        return ResponseEntity.ok().body(itaskService.updateTask(task));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/task/v1/1 (or any other id)
     * Purpose: Delete a Task entity
     * @param id - task's id to be deleted
     * @return a String message indicating task record has been deleted successfully
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Long id)
    {
        itaskService.deleteTaskById(id);
        return ResponseEntity.ok().body("Deleted task successfully");
    }

}
