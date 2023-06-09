package com.api.ToDoApp.controller;


import com.api.ToDoApp.persistence.entity.Task;
import com.api.ToDoApp.persistence.entity.TaskStatus;
import com.api.ToDoApp.service.TaskService;
import com.api.ToDoApp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task creteTask(@RequestBody TaskInDTO taskInDTO) {
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> taskList() {
        return this.taskService.taskList();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus status) {
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id) {
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTask(@PathVariable("id") Long id){
        this.taskService.deleteTask(id);
         return  new ResponseEntity("Usuario eliminado exitosamente", HttpStatus.OK);
    }
}
