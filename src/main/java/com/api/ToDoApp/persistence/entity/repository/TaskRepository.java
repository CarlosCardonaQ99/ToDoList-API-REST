package com.api.ToDoApp.persistence.entity.repository;

import com.api.ToDoApp.persistence.entity.Task;
import com.api.ToDoApp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //Consulta usando Spring Data JPA
    public List<Task> findAllByTaskStatus(TaskStatus status);

    //Query nativa
    @Modifying
    @Query(value = "UPDATE TASK SET FINISHED=true WHERE ID=:id", nativeQuery = true)
    public  void MarTaskAsFinished (@Param("id")Long id);


}
