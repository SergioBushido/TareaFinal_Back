package com.gestor.gestortareasbackend.model.task.dto;

import com.gestor.gestortareasbackend.model.project.Project;
import com.gestor.gestortareasbackend.model.project.dto.ResponseProject;
import com.gestor.gestortareasbackend.model.task.Task;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-17T08:08:03+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
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
        responseTask.project( projectToResponseProject( task.getProject() ) );

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

    protected Set<ResponseTask> taskSetToResponseTaskSet(Set<Task> set) {
        if ( set == null ) {
            return null;
        }

        Set<ResponseTask> set1 = new LinkedHashSet<ResponseTask>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Task task : set ) {
            set1.add( taskToResponseTask( task ) );
        }

        return set1;
    }

    protected ResponseProject projectToResponseProject(Project project) {
        if ( project == null ) {
            return null;
        }

        ResponseProject.ResponseProjectBuilder responseProject = ResponseProject.builder();

        responseProject.id( project.getId() );
        responseProject.name( project.getName() );
        responseProject.tasks( taskSetToResponseTaskSet( project.getTasks() ) );

        return responseProject.build();
    }
}
