package com.sat.springboottodoapplication;

import com.sat.springboottodoapplication.DAO.model.User;
import com.sat.springboottodoapplication.DAO.impl.TaskRepo;
import com.sat.springboottodoapplication.DAO.impl.UserRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@EnableJpaRepositories("com.sat.springboottodoapplication")
@SpringBootApplication
public class SpringBootToDoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootToDoApplication.class, args);
    }

    @Bean
    ApplicationRunner init(TaskRepo repo, UserRepo userRepo){
        return args -> {
//            Random rd = new Random();
//            Stream.of("Buy milk", "Eat pizza", "Update tutorial", "Study Vue", "Go kayaking").forEach(title -> {
//                Task todo = new Task();
//                todo.setTitle(title);
//                todo.setStatus(Status.UNDONE);
//                repo.save(todo);
//            });
//            repo.save(new Task("task1", "this is description of task1", Status.UNDONE))
//            repo.findAll().forEach(System.out::println);

            User admin = new User();
            admin.setEmail("admin@gmail.com");
            admin.setName("admin");
            admin.setPassHash(225555);

            userRepo.save(admin);
        };
    }
}
