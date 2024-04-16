package com.gestor.gestortareasbackend.model.project.dto;

import com.gestor.gestortareasbackend.model.project.Project;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T17:32:04+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class ProjectResponseMapperImpl implements ProjectResponseMapper {

    @Override
    public ResponseProject projectToResponseProject(Project project) {
        if ( project == null ) {
            return null;
        }

        ResponseProject.ResponseProjectBuilder responseProject = ResponseProject.builder();

        return responseProject.build();
    }
}
