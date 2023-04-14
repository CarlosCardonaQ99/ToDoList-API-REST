package com.api.ToDoApp.persistence.entity.repository;

import com.api.ToDoApp.persistence.entity.Task;
import com.api.ToDoApp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //Consulta usando Spring Dara JPA finByStatus
    public List<Task> findAllByTaskStatus(TaskStatus status);


}
