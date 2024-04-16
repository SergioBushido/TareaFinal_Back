package com.gestor.gestortareasbackend.model.comment.dto;

import com.gestor.gestortareasbackend.model.comment.Comment;
import com.gestor.gestortareasbackend.model.task.dto.TaskResponseMapper;
import com.gestor.gestortareasbackend.model.user.dto.UserResponseMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T17:32:32+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
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
    }
}
