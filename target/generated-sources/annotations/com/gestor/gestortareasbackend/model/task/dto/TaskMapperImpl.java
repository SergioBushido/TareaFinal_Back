package com.gestor.gestortareasbackend.model.task.dto;

import com.gestor.gestortareasbackend.model.task.Task;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-17T08:01:47+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task mapResponseTaskToTask(ResponseTask responseTask) {
        if ( responseTask == null ) {
            return null;
        }

        Task task = new Task();

        return task;
    }
}
