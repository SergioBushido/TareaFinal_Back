package com.gestor.gestortareasbackend.model.comment.dto;

import com.gestor.gestortareasbackend.model.comment.Comment;
import com.gestor.gestortareasbackend.model.project.Project;
import com.gestor.gestortareasbackend.model.project.dto.ResponseProject;
import com.gestor.gestortareasbackend.model.tag.Tag;
import com.gestor.gestortareasbackend.model.tag.dto.ResponseTag;
import com.gestor.gestortareasbackend.model.task.Task;
import com.gestor.gestortareasbackend.model.task.dto.ResponseTask;
import com.gestor.gestortareasbackend.model.task.dto.TaskResponseMapper;
import com.gestor.gestortareasbackend.model.user.User;
import com.gestor.gestortareasbackend.model.user.dto.ResponseUser;
import com.gestor.gestortareasbackend.model.user.dto.UserResponseMapper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-17T08:11:13+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class CommentResponseMapperImpl implements CommentResponseMapper {

    @Autowired
    private UserResponseMapper userResponseMapper;
    @Autowired
    private TaskResponseMapper taskResponseMapper;

    @Override
    public ResponseComment commentToResponseComment(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        ResponseComment.ResponseCommentBuilder responseComment = ResponseComment.builder();

        responseComment.id( comment.getId() );
        responseComment.content( comment.getContent() );
        responseComment.user( userResponseMapper.userToResponseUser( comment.getUser() ) );
        responseComment.task( taskResponseMapper.taskToResponseTask( comment.getTask() ) );

        return responseComment.build();
    }

    @Override
    public List<ResponseComment> commentsToResponseComments(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<ResponseComment> list = new ArrayList<ResponseComment>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( commentToResponseComment( comment ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(RequestComment dto, Comment entity) {
        if ( dto == null ) {
            return;
        }

        entity.setContent( dto.getContent() );
        if ( dto.getUser() != null ) {
            if ( entity.getUser() == null ) {
                entity.setUser( User.builder().build() );
            }
            responseUserToUser( dto.getUser(), entity.getUser() );
        }
        else {
            entity.setUser( null );
        }
        if ( dto.getTask() != null ) {
            if ( entity.getTask() == null ) {
                entity.setTask( Task.builder().build() );
            }
            responseTaskToTask( dto.getTask(), entity.getTask() );
        }
        else {
            entity.setTask( null );
        }
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
            set1.add( responseTaskToTask( responseTask ) );
        }

        return set1;
    }

    protected Project responseProjectToProject(ResponseProject responseProject) {
        if ( responseProject == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( responseProject.getId() );
        project.setName( responseProject.getName() );
        project.setTasks( responseTaskSetToTaskSet( responseProject.getTasks() ) );

        return project;
    }

    protected Tag responseTagToTag(ResponseTag responseTag) {
        if ( responseTag == null ) {
            return null;
        }

        Tag.TagBuilder tag = Tag.builder();

        tag.id( responseTag.getId() );
        tag.name( responseTag.getName() );

        return tag.build();
    }

    protected Set<Tag> responseTagSetToTagSet(Set<ResponseTag> set) {
        if ( set == null ) {
            return null;
        }

        Set<Tag> set1 = new LinkedHashSet<Tag>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ResponseTag responseTag : set ) {
            set1.add( responseTagToTag( responseTag ) );
        }

        return set1;
    }

    protected Task responseTaskToTask(ResponseTask responseTask) {
        if ( responseTask == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.id( responseTask.getId() );
        task.name( responseTask.getName() );
        task.project( responseProjectToProject( responseTask.getProject() ) );
        task.tags( responseTagSetToTagSet( responseTask.getTags() ) );

        return task.build();
    }

    protected void responseProjectToProject(ResponseProject responseProject, Project mappingTarget) {
        if ( responseProject == null ) {
            return;
        }

        mappingTarget.setId( responseProject.getId() );
        mappingTarget.setName( responseProject.getName() );
        if ( mappingTarget.getTasks() != null ) {
            Set<Task> set = responseTaskSetToTaskSet( responseProject.getTasks() );
            if ( set != null ) {
                mappingTarget.getTasks().clear();
                mappingTarget.getTasks().addAll( set );
            }
            else {
                mappingTarget.setTasks( null );
            }
        }
        else {
            Set<Task> set = responseTaskSetToTaskSet( responseProject.getTasks() );
            if ( set != null ) {
                mappingTarget.setTasks( set );
            }
        }
    }

    protected void responseTaskToTask(ResponseTask responseTask, Task mappingTarget) {
        if ( responseTask == null ) {
            return;
        }

        mappingTarget.setId( responseTask.getId() );
        mappingTarget.setName( responseTask.getName() );
        if ( responseTask.getProject() != null ) {
            if ( mappingTarget.getProject() == null ) {
                mappingTarget.setProject( new Project() );
            }
            responseProjectToProject( responseTask.getProject(), mappingTarget.getProject() );
        }
        else {
            mappingTarget.setProject( null );
        }
        if ( mappingTarget.getTags() != null ) {
            Set<Tag> set = responseTagSetToTagSet( responseTask.getTags() );
            if ( set != null ) {
                mappingTarget.getTags().clear();
                mappingTarget.getTags().addAll( set );
            }
            else {
                mappingTarget.setTags( null );
            }
        }
        else {
            Set<Tag> set = responseTagSetToTagSet( responseTask.getTags() );
            if ( set != null ) {
                mappingTarget.setTags( set );
            }
        }
    }
}
