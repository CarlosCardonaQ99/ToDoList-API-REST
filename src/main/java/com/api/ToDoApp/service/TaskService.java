package com.api.ToDoApp.service;

import com.api.ToDoApp.exceptions.ToDoExceptions;
import com.api.ToDoApp.mapper.TaskInDTOToTask;
import com.api.ToDoApp.persistence.entity.Task;
import com.api.ToDoApp.persistence.entity.TaskStatus;
import com.api.ToDoApp.persistence.entity.repository.TaskRepository;
import com.api.ToDoApp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    private final TaskInDTOToTask taskInDTOToTask;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.taskRepository = repository;
        this.taskInDTOToTask = mapper;
    }

    //Crear una nueva tarea
    public Task createTask(TaskInDTO taskInDTO) {
        Task task = taskInDTOToTask.map(taskInDTO); //tenemos el objeto taskInDTO convertido en un objeto Task
        return this.taskRepository.save(task);
    }

    //Método que permita obtener todas las tareas
    public List<Task> taskList() {
        return this.taskRepository.findAll();
    }

    //Consultar por status
    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.taskRepository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Tarea no encontrada ", HttpStatus.NOT_FOUND);
        }

        this.taskRepository.MarTaskAsFinished(id);
    }

    public void deleteTask(Long id){
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("El usuario a eliminar no existe ", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);
    }
}
