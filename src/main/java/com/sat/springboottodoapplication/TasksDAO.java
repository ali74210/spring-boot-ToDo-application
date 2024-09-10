package com.sat.springboottodoapplication;
import com.sat.springboottodoapplication.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TasksDAO extends JpaRepository<Task, Long> {

}
