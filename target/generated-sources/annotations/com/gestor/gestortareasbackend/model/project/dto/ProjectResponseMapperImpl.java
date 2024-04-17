package com.gestor.gestortareasbackend.model.project.dto;

import com.gestor.gestortareasbackend.model.project.Project;
import com.gestor.gestortareasbackend.model.tag.Tag;
import com.gestor.gestortareasbackend.model.tag.dto.ResponseTag;
import com.gestor.gestortareasbackend.model.task.Task;
import com.gestor.gestortareasbackend.model.task.dto.ResponseTask;
import com.gestor.gestortareasbackend.model.task.dto.TaskMapper;
import com.gestor.gestortareasbackend.model.user.User;
import com.gestor.gestortareasbackend.model.user.dto.ResponseUser;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-17T08:09:17+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ProjectResponseMapperImpl implements ProjectResponseMapper {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public ResponseProject entityToResponse(Project project) {
        if ( project == null ) {
            return null;
        }

        ResponseProject.ResponseProjectBuilder responseProject = ResponseProject.builder();

        responseProject.id( project.getId() );
        responseProject.name( project.getName() );
        responseProject.member( userToResponseUser( project.getUser() ) );
        responseProject.tasks( taskSetToResponseTaskSet( project.getTasks() ) );

        return responseProject.build();
    }

    @Override
    public List<ResponseProject> entitiesToResponses(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ResponseProject> list = new ArrayList<ResponseProject>( projects.size() );
        for ( Project project : projects ) {
            list.add( entityToResponse( project ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(RequestProject dto, Project entity) {
        if ( dto == null ) {
            return;
        }

        entity.setName( dto.getName() );
        if ( dto.getMember() != null ) {
            if ( entity.getUser() == null ) {
                entity.setUser( User.builder().build() );
            }
            responseUserToUser( dto.getMember(), entity.getUser() );
        }
        else {
            entity.setUser( null );
        }
        if ( entity.getTasks() != null ) {
            Set<Task> set = responseTaskSetToTaskSet( dto.getTasks() );
            if ( set != null ) {
                entity.getTasks().clear();
                entity.getTasks().addAll( set );
            }
            else {
                entity.setTasks( null );
            }
        }
        else {
            Set<Task> set = responseTaskSetToTaskSet( dto.getTasks() );
            if ( set != null ) {
                entity.setTasks( set );
            }
        }
    }

    protected ResponseUser userToResponseUser(User user) {
        if ( user == null ) {
            return null;
        }

        ResponseUser.ResponseUserBuilder responseUser = ResponseUser.builder();

        responseUser.id( user.getId() );
        responseUser.username( user.getUsername() );
        responseUser.email( user.getEmail() );

        return responseUser.build();
    }

    protected ResponseTag tagToResponseTag(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        ResponseTag.ResponseTagBuilder responseTag = ResponseTag.builder();

        responseTag.id( tag.getId() );
        responseTag.name( tag.getName() );

        return responseTag.build();
    }

    protected Set<ResponseTag> tagSetToResponseTagSet(Set<Tag> set) {
        if ( set == null ) {
            return null;
        }

        Set<ResponseTag> set1 = new LinkedHashSet<ResponseTag>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Tag tag : set ) {
            set1.add( tagToResponseTag( tag ) );
        }

        return set1;
    }

    protected ResponseTask taskToResponseTask(Task task) {
        if ( task == null ) {
            return null;
        }

        ResponseTask.ResponseTaskBuilder responseTask = ResponseTask.builder();

        responseTask.id( task.getId() );
        responseTask.name( task.getName() );
        responseTask.project( entityToResponse( task.getProject() ) );
        responseTask.tags( tagSetToResponseTagSet( task.getTags() ) );

        return responseTask.build();
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

    protected void responseUserToUser(ResponseUser responseUser, User mappingTarget) {
        if ( responseUser == null ) {
            return;
        }

        mappingTarget.setId( responseUser.getId() );
        mappingTarget.setUsername( responseUser.getUsername() );
        mappingTarget.setEmail( responseUser.getEmail() );
    }

    protected Set<Task> responseTaskSetToTaskSet(Set<ResponseTask> set) {
        if ( set == null ) {
            return null;
        }

        Set<Task> set1 = new LinkedHashSet<Task>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ResponseTask responseTask : set ) {
            set1.add( taskMapper.mapResponseTaskToTask( responseTask ) );
        }

        return set1;
    }
}
