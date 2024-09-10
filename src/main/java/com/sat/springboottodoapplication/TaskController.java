package com.sat.springboottodoapplication;

import com.sat.springboottodoapplication.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "task/v1")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/task/v1/
     * Purpose: Fetches all the tasks in the task table
     * @return List of tasks
     */
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/task/v1/1 (or any other id)
     * Purpose: Fetches task with the given id
     * @param id - task id
     * @return task with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    /**
     * This method is called when a POST request is made
     * URL: localhost:8080/task/v1/
     * Purpose: Save a Task entity
     * @param task - Request body is a Task entity
     * @return Saved Task entity
     */
    @PostMapping("/")
    public ResponseEntity<Task> saveTask(@RequestBody Task task)
    {
        return ResponseEntity.ok().body(taskService.saveTask(task));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/task/v1/
     * Purpose: Update a Task entity
     * @param task - Task entity to be updated
     * @return Updated Task
     */
    @PutMapping("/")
    public ResponseEntity<Task> updateTask(@RequestBody Task task)
    {
        return ResponseEntity.ok().body(taskService.updateTask(task));
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
        taskService.deleteTaskById(id);
        return ResponseEntity.ok().body("Deleted task successfully");
    }

}
