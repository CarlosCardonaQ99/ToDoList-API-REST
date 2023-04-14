package com.api.ToDoApp.persistence.entity.repository;

import com.api.ToDoApp.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
