package com.api.ToDoApp.controller;


import com.api.ToDoApp.persistence.entity.Task;
import com.api.ToDoApp.service.TaskService;
import com.api.ToDoApp.service.dto.TaskInDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private  final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task creteTask(@RequestBody TaskInDTO taskInDTO){
       return this.taskService.createTask(taskInDTO);
    }
}
