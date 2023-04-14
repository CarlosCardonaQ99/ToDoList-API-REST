package com.api.ToDoApp.mapper;

import com.api.ToDoApp.persistence.entity.Task;
import com.api.ToDoApp.persistence.entity.TaskStatus;
import com.api.ToDoApp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//Implementa la interfaz IMapper, especificando el origen (TaskInDTO) y la salida (Task)
//Este Mapper nos conierte un TaskInDTO(que por simplicidad no tiene todos los elementos necesarios
// para guardar en la bd) a un Task que sí se relacione con la entidad para ser almacenado.

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task> {

    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task(); //Creamos es Task que vamos a devolver
        task.setTitle(in.getTitle()); //Seteamos el título usando el que haya puesto el usuario en el DTO
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        //Estos elementos no estaban en el DTO, pero los creamos automáticamente, sin preguntarle al usuario
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);

        return task;
    }
}
