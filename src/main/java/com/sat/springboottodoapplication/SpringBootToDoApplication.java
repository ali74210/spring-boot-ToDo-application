package com.sat.springboottodoapplication;

import com.sat.springboottodoapplication.model.Status;
import com.sat.springboottodoapplication.model.Task;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootToDoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootToDoApplication.class, args);
    }

    @Bean
    ApplicationRunner init(TasksDAO repo){
        return args -> {
            Random rd = new Random();
            Stream.of("Buy milk", "Eat pizza", "Update tutorial", "Study Vue", "Go kayaking").forEach(title -> {
                Task todo = new Task();
                todo.setTitle(title);
                todo.setStatus(Status.UNDONE);
                repo.save(todo);
            });
            repo.findAll().forEach(System.out::println);
        };
    }
}
