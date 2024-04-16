package com.gestor.gestortareasbackend.model.task.dto;

import com.gestor.gestortareasbackend.model.task.Task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T17:33:35+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class TaskResponseMapperImpl implements TaskResponseMapper {

    @Override
    public ResponseTask taskToResponseTask(Task task) {
        if ( task == null ) {
            return null;
        }

        ResponseTask.ResponseTaskBuilder responseTask = ResponseTask.builder();

        responseTask.id( task.getId() );
        responseTask.name( task.getName() );
        responseTask.tags( mapTags( task.getTags() ) );

        return responseTask.build();
    }

    @Override
    public List<ResponseTask> tasksToResponseTasks(List<Task> tasks) {
        if ( tasks == null ) {
            return null;
        }

        List<ResponseTask> list = new ArrayList<ResponseTask>( tasks.size() );
        for ( Task task : tasks ) {
            list.add( taskToResponseTask( task ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(RequestTask dto, Task entity) {
        if ( dto == null ) {
            return;
        }

        entity.setName( dto.getName() );
    }
}
