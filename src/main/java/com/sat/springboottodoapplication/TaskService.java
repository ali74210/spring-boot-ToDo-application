package com.sat.springboottodoapplication;

import com.sat.springboottodoapplication.model.Task;
import com.sat.springboottodoapplication.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {
    public List<Task> getTasks(){
        return List.of(
                new Task("first", "ascascascasc", new User("ali", "123456"))
        );
    }
}
