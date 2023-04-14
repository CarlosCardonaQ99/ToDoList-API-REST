package com.api.ToDoApp.service.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskInDTO {

    private String title;
    private String description;
    private LocalDateTime eta; //fecha de finalización estimada
}
