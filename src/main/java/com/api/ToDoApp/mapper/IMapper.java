package com.api.ToDoApp.mapper;

//este mapper recibe un dato de entrada I y recibe un dato de salida O
public interface IMapper <I, O>{
    public O map(I in);
}
