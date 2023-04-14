package com.api.ToDoApp.service;

import com.api.ToDoApp.mapper.TaskInDTOToTask;
import com.api.ToDoApp.persistence.entity.Task;
import com.api.ToDoApp.persistence.entity.TaskStatus;
import com.api.ToDoApp.persistence.entity.repository.TaskRepository;
import com.api.ToDoApp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    private final TaskInDTOToTask taskInDTOToTask;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.taskRepository = repository;
        this.taskInDTOToTask = mapper;
    }

        //Crear una nueva tarea
    public Task createTask(TaskInDTO taskInDTO){
        Task task = taskInDTOToTask.map(taskInDTO); //tenemos el objeto taskInDTO convertido en un objeto Task
        return this.taskRepository.save(task);
    }

    //Método que permita obtener todas las tareas
    public List<Task> taskList(){
        return  this.taskRepository.findAll();
    }

    //Consultar por status
    public List<Task> findAllByTaskStatus(TaskStatus status){
        return  this.taskRepository.findAllByTaskStatus(status);
    }
}
